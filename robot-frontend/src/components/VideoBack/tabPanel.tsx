import React, {useEffect, useState} from "react";
import {Col, Row, Tree, TreeSelect} from "antd";
import {DownOutlined} from "@ant-design/icons";
import type { DataNode } from 'antd/es/tree';
import {Player, ControlBar, BigPlayButton} from 'video-react'

import {getVideoTree, getVideoUrl} from "../../api/video";

export default function TabPanel(){

    const { TreeNode } = TreeSelect;

    const [treeData,setTreeData] = useState<DataNode[]>([])

    const [currentSrc,setCurrentSrc] = useState("")

    const [player,setPlayer] = useState()

    const [a,seta] = useState(false)
    const [b,setb] = useState(true)

    const getVideoList = () => {
      getVideoTree().then(res=>{
          setTreeData(res.data)
          console.log(res.data)
      })
    }

    const renderTreeNodes = data =>
        data.map(item => {
            if (item.children) {
                item.disabled = true;
                return (
                    <TreeNode key={item.key} title={item.title} value={item.value} disabled={item.disabled}>
                        {renderTreeNodes(item.children)}
                    </TreeNode>
                );
            }
            return <TreeNode {...item} key={item.key} title={item.title} value={item.value} />;
        });


    const onselect = (selectedKeys) => {
            setCurrentSrc(`http://192.168.1.124:40/video${selectedKeys}`)
        console.log(`http://${selectedKeys}`)
    }

    useEffect(()=>{
        getVideoList()
    },[])


    return(
        <div>
            <Row>
                <Col span={6}>
                    {renderTreeNodes(treeData)}
                        <Tree
                            showIcon
                            switcherIcon={<DownOutlined />}
                            onSelect={onselect}
                            treeData={treeData}
                        />
                </Col>
                <Col span={18}>
                    <Player
                        ref={(ref) => {
                            setPlayer(ref);
                        }}
                        width="100%"
                        src={currentSrc}
                    >
                        <BigPlayButton position="center"/>
                        <ControlBar/>
                    </Player>
                </Col>
            </Row>
        </div>
    )
}
