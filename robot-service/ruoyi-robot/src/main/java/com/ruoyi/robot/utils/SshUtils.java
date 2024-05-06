package com.ruoyi.robot.utils;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import com.ruoyi.robot.domain.vo.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class SshUtils {

    public static String ip = "192.168.1.124";

    public static Integer port = 22;

    public static String LiuxUser = "space-robot";
    public static String LiuxPawd = "123456";

    public static String path = "/home/space-robot/ptz/8M07C25PAJ19349";

    public static String tempPath = "/home/space-robot/ptz/8M07C25PAJ19349/";

    public static List<Menu> getFileList() {
        Connection conn = new Connection(ip,port);
        try {
            conn.connect();
            boolean b = conn.authenticateWithPassword(LiuxUser, LiuxPawd);
            if (b) {
                Session session = conn.openSession();
                session.execCommand("cd " + path + "\n" +
                        "find $(pwd) -name \"*.mp4\"");
                BufferedReader reader = new BufferedReader(new InputStreamReader(new StreamGobbler(session.getStdout())));
                return getFilePathTree(reader.lines().collect(Collectors.toList()));
            }
            conn.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static String convertVidep(String fileName) {
        Connection conn = new Connection(ip,port);
        try {
            conn.connect();
            boolean b = conn.authenticateWithPassword(LiuxUser, LiuxPawd);
            if (b) {
                Session session = conn.openSession();
                String substring = fileName.replace("dav","mp4");
                String s = substring.substring(0, substring.indexOf("mp4")) + "mp4";
                String sq = substring.replace(s,"").split("/")[1];
                String a = s+"/"+sq;
                session.execCommand(
                                "cd " + path + "\n"+
                                        "mkdir " + path + s + "\n" +
                                        "mkdir " + path + a + "\n"
                                + "ffmpeg -i " + path + fileName + " -vcodec copy -acodec copy " + tempPath + substring
                );
                BufferedReader reader = new BufferedReader(new InputStreamReader(new StreamGobbler(session.getStdout())));
                return ip + ":40/video" + substring;
            }
            conn.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static List<Menu> getFilePathTree(List<String> paths) {
        List<Menu> menus = new ArrayList<>();

        paths.stream().map(it -> it.replaceFirst(path+"/" ,"")).forEach(path -> {
                    addMenu(menus, path,"");
                });
        return menus;
    }

    public static void addMenu(List<Menu> menus, String path , String perPath) {
        String split = path.split("/")[0];
        String reStr = path.replaceFirst(split + "/", "");
        if (!path.contains("/")) {
            Menu menu = new Menu();
            menu.setId(0);
            menu.setKey(perPath + "/" +split);
            menu.setTitle(split);
            menus.add(menu);
            return;
        }
        if (menus.stream().anyMatch(it -> it.getTitle().equals(split))) {
            menus = menus.stream().peek(it -> {
                if (Objects.equals(it.getTitle(), split)) {
                    if (it.getChildren() == null) {
                        it.setChildren(new ArrayList<>());
                    }
                    addMenu(it.getChildren(), reStr,perPath + "/" +split);
                }
            }).collect(Collectors.toList());
        } else {
            Menu menu = new Menu();
            menu.setId(0);
            menu.setKey(perPath + "/" +split);
            menu.setTitle(split);
            ArrayList<Menu> list = new ArrayList<>();
            addMenu(list, reStr,perPath + "/" +split);
            menu.setChildren(list);
            menus.add(menu);

        }
    }
}
