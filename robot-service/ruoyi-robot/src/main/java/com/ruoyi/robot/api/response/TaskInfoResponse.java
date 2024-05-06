package com.ruoyi.robot.api.response;

import java.util.List;

public class TaskInfoResponse {

    /**
     * ack : 0
     * data : {"header":[{"id":"task_name","name":"任务名称","type":"string"},{"id":"task_id","name":"任务编号","type":"string"},{"id":"parent_task_id","name":"父任务编号","type":"string"},{"id":"state","name":"状态","type":"string"},{"id":"info","name":"信息","type":"string"},{"id":"begin_time","name":"开始时间","type":"string"},{"id":"end_time","name":"结束时间","type":"string"}],"infos":[{"begin_time":"2023-04-28 03:13:02","end_time":"2023-04-28 03:15:08","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"7fdfe2d12966654f","task_name":"巡检"},{"begin_time":"2023-04-28 03:10:56","end_time":"2023-04-28 03:13:02","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"13579018cd1cf3ae","task_name":"巡检"},{"begin_time":"2023-04-28 03:08:51","end_time":"2023-04-28 03:10:56","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"c623d156e7284aea","task_name":"巡检"},{"begin_time":"2023-04-28 03:06:45","end_time":"2023-04-28 03:08:51","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"8850fafed2241209","task_name":"巡检"},{"begin_time":"2023-04-28 03:04:40","end_time":"2023-04-28 03:06:45","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"91c609f2be325691","task_name":"巡检"},{"begin_time":"2023-04-28 03:02:34","end_time":"2023-04-28 03:04:40","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"27b246819b9a3850","task_name":"巡检"},{"begin_time":"2023-04-28 03:00:28","end_time":"2023-04-28 03:02:34","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"03cd7f0790dc9465","task_name":"巡检"},{"begin_time":"2023-04-28 02:58:22","end_time":"2023-04-28 03:00:28","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"8f9f3b16c944e531","task_name":"巡检"},{"begin_time":"2023-04-28 02:56:16","end_time":"2023-04-28 02:58:22","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"cb5dc4837e37a460","task_name":"巡检"},{"begin_time":"2023-04-28 02:54:10","end_time":"2023-04-28 02:56:16","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"ca3f546db4a6c147","task_name":"巡检"},{"begin_time":"2023-04-28 02:52:04","end_time":"2023-04-28 02:54:10","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"c388286005e22d4b","task_name":"巡检"},{"begin_time":"2023-04-28 02:49:58","end_time":"2023-04-28 02:52:04","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"c1bb0c83781c0309","task_name":"巡检"},{"begin_time":"2023-04-28 02:47:53","end_time":"2023-04-28 02:49:58","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"9d462c2212db3c92","task_name":"巡检"},{"begin_time":"2023-04-28 02:45:47","end_time":"2023-04-28 02:47:53","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"1013e3dc83887b8f","task_name":"巡检"},{"begin_time":"2023-04-28 02:43:43","end_time":"2023-04-28 02:45:47","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"88464fd3629deca4","task_name":"巡检"},{"begin_time":"2023-04-28 02:41:37","end_time":"2023-04-28 02:43:43","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"0d72e4e9a70e4b4b","task_name":"巡检"},{"begin_time":"2023-04-28 02:39:31","end_time":"2023-04-28 02:41:37","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"f972cf220e157cef","task_name":"巡检"},{"begin_time":"2023-04-28 02:37:26","end_time":"2023-04-28 02:39:31","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"d09695a994bfc931","task_name":"巡检"},{"begin_time":"2023-04-28 02:35:20","end_time":"2023-04-28 02:37:26","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"1e94fc7999fc897b","task_name":"巡检"},{"begin_time":"2023-04-28 02:33:14","end_time":"2023-04-28 02:35:20","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"94c74aae51d49f1d","task_name":"巡检"},{"begin_time":"2023-04-28 02:31:08","end_time":"2023-04-28 02:33:14","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"3fc9005397df5903","task_name":"巡检"},{"begin_time":"2023-04-28 02:29:02","end_time":"2023-04-28 02:31:08","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"4618e40e8207f372","task_name":"巡检"},{"begin_time":"2023-04-28 02:26:56","end_time":"2023-04-28 02:29:02","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"4b62e275228d4a38","task_name":"巡检"},{"begin_time":"2023-04-28 02:24:50","end_time":"2023-04-28 02:26:56","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"5602ec5dcb10c34e","task_name":"巡检"},{"begin_time":"2023-04-28 02:22:43","end_time":"2023-04-28 02:24:50","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"4cb981d99cb69fff","task_name":"巡检"},{"begin_time":"2023-04-28 02:20:38","end_time":"2023-04-28 02:22:43","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"3e4f66f05adada54","task_name":"巡检"},{"begin_time":"2023-04-28 02:18:32","end_time":"2023-04-28 02:20:38","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"57ac606e43defdc9","task_name":"巡检"},{"begin_time":"2023-04-28 02:16:26","end_time":"2023-04-28 02:18:32","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"cd1a40203d8c9326","task_name":"巡检"},{"begin_time":"2023-04-28 02:14:20","end_time":"2023-04-28 02:16:26","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"50ff2329f2950d32","task_name":"巡检"},{"begin_time":"2023-04-28 02:12:14","end_time":"2023-04-28 02:14:20","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"c13d94b1c69faaf9","task_name":"巡检"},{"begin_time":"2023-04-28 02:10:07","end_time":"2023-04-28 02:12:14","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"0a830fbc00750bc6","task_name":"巡检"},{"begin_time":"2023-04-28 02:08:02","end_time":"2023-04-28 02:10:07","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"1750204759909c00","task_name":"巡检"},{"begin_time":"2023-04-28 02:05:55","end_time":"2023-04-28 02:08:01","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"c93a7d68bd9826e8","task_name":"巡检"},{"begin_time":"2023-04-28 02:03:49","end_time":"2023-04-28 02:05:55","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"00aaddf6506f889a","task_name":"巡检"},{"begin_time":"2023-04-28 02:01:44","end_time":"2023-04-28 02:03:49","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"34fd8f0aaf6f7245","task_name":"巡检"},{"begin_time":"2023-04-28 01:59:38","end_time":"2023-04-28 02:01:44","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"3e9906d8e567dd8c","task_name":"巡检"},{"begin_time":"2023-04-28 01:57:31","end_time":"2023-04-28 01:59:38","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"5177c9a8f9ac5a28","task_name":"巡检"},{"begin_time":"2023-04-28 01:55:25","end_time":"2023-04-28 01:57:31","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"3cc9a01006b4a372","task_name":"巡检"},{"begin_time":"2023-04-28 01:53:18","end_time":"2023-04-28 01:55:25","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"839957457c0b813a","task_name":"巡检"},{"begin_time":"2023-04-28 01:51:12","end_time":"2023-04-28 01:53:18","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"bfbc45be70ae303a","task_name":"巡检"},{"begin_time":"2023-04-28 01:49:05","end_time":"2023-04-28 01:51:12","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"1ba1f2bb1c03ccf3","task_name":"巡检"},{"begin_time":"2023-04-28 01:47:00","end_time":"2023-04-28 01:49:05","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"eb9307ed72335114","task_name":"巡检"},{"begin_time":"2023-04-28 01:44:53","end_time":"2023-04-28 01:47:00","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"34ba073552cf3e52","task_name":"巡检"},{"begin_time":"2023-04-28 01:42:47","end_time":"2023-04-28 01:44:53","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"c56c584676137d6d","task_name":"巡检"},{"begin_time":"2023-04-28 01:40:39","end_time":"2023-04-28 01:42:47","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"4c4bd66f2514c4aa","task_name":"巡检"},{"begin_time":"2023-04-28 01:38:33","end_time":"2023-04-28 01:40:39","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"5763af30c1d31bd2","task_name":"巡检"},{"begin_time":"2023-04-28 01:36:26","end_time":"2023-04-28 01:38:33","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"d1cb6e1e9ff7d2f7","task_name":"巡检"},{"begin_time":"2023-04-28 01:34:19","end_time":"2023-04-28 01:36:26","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"ca25743a6b368ab9","task_name":"巡检"},{"begin_time":"2023-04-28 01:32:13","end_time":"2023-04-28 01:34:19","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"024d0a1d2fa5d013","task_name":"巡检"},{"begin_time":"2023-04-28 01:30:06","end_time":"2023-04-28 01:32:13","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"af1dbfeae5f70e0a","task_name":"巡检"},{"begin_time":"2023-04-28 01:28:00","end_time":"2023-04-28 01:30:06","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"17d78d6fbbde8d15","task_name":"巡检"},{"begin_time":"2023-04-28 01:25:53","end_time":"2023-04-28 01:28:00","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"1928ad214e087fe4","task_name":"巡检"},{"begin_time":"2023-04-28 01:23:47","end_time":"2023-04-28 01:25:53","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"6b59671b81c89e54","task_name":"巡检"},{"begin_time":"2023-04-28 01:21:40","end_time":"2023-04-28 01:23:47","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"05d239151d852c17","task_name":"巡检"},{"begin_time":"2023-04-28 01:19:34","end_time":"2023-04-28 01:21:40","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"59cde3c0a3c4a386","task_name":"巡检"},{"begin_time":"2023-04-28 01:17:26","end_time":"2023-04-28 01:19:34","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"dbab95c073552b5c","task_name":"巡检"},{"begin_time":"2023-04-28 01:15:20","end_time":"2023-04-28 01:17:26","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"cf6b945427e6e876","task_name":"巡检"},{"begin_time":"2023-04-28 01:13:12","end_time":"2023-04-28 01:15:20","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"5b684369b599edb9","task_name":"巡检"},{"begin_time":"2023-04-28 01:11:05","end_time":"2023-04-28 01:13:12","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"69acc7513368952e","task_name":"巡检"},{"begin_time":"2023-04-28 01:08:59","end_time":"2023-04-28 01:11:05","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"59909474d6126061","task_name":"巡检"},{"begin_time":"2023-04-27 15:56:43","end_time":"2023-04-27 16:00:50","info":"","parent_task_id":"9e6173f87a853d59","state":"已完成","task_id":"d95441b0b93f3ed8","task_name":"d403-巡检"},{"begin_time":"2023-04-27 15:50:57","end_time":"2023-04-27 15:55:03","info":"","parent_task_id":"9e6173f87a853d59","state":"已完成","task_id":"4e803c6cc7178db1","task_name":"d403-巡检"},{"begin_time":"2023-04-27 15:43:24","end_time":"2023-04-27 15:47:33","info":"","parent_task_id":"9e6173f87a853d59","state":"已完成","task_id":"c7f026bf5fc9251d","task_name":"d403-巡检"},{"begin_time":"2023-04-27 15:35:03","end_time":"2023-04-27 15:39:11","info":"","parent_task_id":"9e6173f87a853d59","state":"已完成","task_id":"164bb17d05f9866f","task_name":"d403-巡检"},{"begin_time":"2023-04-27 15:29:16","end_time":"2023-04-27 15:33:24","info":"","parent_task_id":"9e6173f87a853d59","state":"已完成","task_id":"ddd559356a362b2f","task_name":"d403-巡检"},{"begin_time":"2023-04-27 15:14:02","end_time":"2023-04-27 15:18:09","info":"","parent_task_id":"9e6173f87a853d59","state":"已完成","task_id":"09b64ac11a66e92e","task_name":"d403-巡检"},{"begin_time":"2023-04-27 03:12:13","end_time":"2023-04-27 03:14:17","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"f712578f4a989658","task_name":"巡检"},{"begin_time":"2023-04-27 03:10:09","end_time":"2023-04-27 03:12:13","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"6fc81d2c64a74c0d","task_name":"巡检"},{"begin_time":"2023-04-27 03:08:04","end_time":"2023-04-27 03:10:09","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"dec50bea7f2af5c7","task_name":"巡检"},{"begin_time":"2023-04-27 03:05:58","end_time":"2023-04-27 03:08:04","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"0bdb998e254a9318","task_name":"巡检"},{"begin_time":"2023-04-27 03:03:53","end_time":"2023-04-27 03:05:58","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"482435a5b82c72f0","task_name":"巡检"},{"begin_time":"2023-04-27 03:01:48","end_time":"2023-04-27 03:03:53","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"0c5d762943049f35","task_name":"巡检"},{"begin_time":"2023-04-27 02:59:42","end_time":"2023-04-27 03:01:48","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"b971607d43bee92c","task_name":"巡检"},{"begin_time":"2023-04-27 02:57:37","end_time":"2023-04-27 02:59:42","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"e755a51fcf6a530e","task_name":"巡检"},{"begin_time":"2023-04-27 02:55:32","end_time":"2023-04-27 02:57:37","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"36fe9b195b3ddeed","task_name":"巡检"},{"begin_time":"2023-04-27 02:53:28","end_time":"2023-04-27 02:55:32","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"a828b62972b33888","task_name":"巡检"},{"begin_time":"2023-04-27 02:51:24","end_time":"2023-04-27 02:53:28","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"ea18686695074cb2","task_name":"巡检"},{"begin_time":"2023-04-27 02:49:18","end_time":"2023-04-27 02:51:24","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"c2a8c12ab1868a39","task_name":"巡检"},{"begin_time":"2023-04-27 02:47:13","end_time":"2023-04-27 02:49:18","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"d64750f1518b7819","task_name":"巡检"},{"begin_time":"2023-04-27 02:45:08","end_time":"2023-04-27 02:47:13","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"a959767c92231332","task_name":"巡检"},{"begin_time":"2023-04-27 02:43:03","end_time":"2023-04-27 02:45:08","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"db7550365246bc01","task_name":"巡检"},{"begin_time":"2023-04-27 02:40:57","end_time":"2023-04-27 02:43:03","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"3a0e1e617b54330c","task_name":"巡检"},{"begin_time":"2023-04-27 02:38:52","end_time":"2023-04-27 02:40:57","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"e02814743d348981","task_name":"巡检"},{"begin_time":"2023-04-27 02:36:46","end_time":"2023-04-27 02:38:52","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"b0351e210e59b8d9","task_name":"巡检"},{"begin_time":"2023-04-27 02:34:41","end_time":"2023-04-27 02:36:46","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"7831fb55946769a7","task_name":"巡检"},{"begin_time":"2023-04-27 02:32:36","end_time":"2023-04-27 02:34:41","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"320b0d907aa88780","task_name":"巡检"},{"begin_time":"2023-04-27 02:30:31","end_time":"2023-04-27 02:32:36","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"1d631b820da3ffcf","task_name":"巡检"},{"begin_time":"2023-04-27 02:28:26","end_time":"2023-04-27 02:30:31","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"c652972dd22b094d","task_name":"巡检"},{"begin_time":"2023-04-27 02:26:21","end_time":"2023-04-27 02:28:26","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"04c544dc5f06d7ab","task_name":"巡检"},{"begin_time":"2023-04-27 02:24:15","end_time":"2023-04-27 02:26:21","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"2835fb9f0fd72545","task_name":"巡检"},{"begin_time":"2023-04-27 02:22:10","end_time":"2023-04-27 02:24:15","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"b9f4cde27207382b","task_name":"巡检"},{"begin_time":"2023-04-27 02:20:05","end_time":"2023-04-27 02:22:10","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"eb661e5f21f0be63","task_name":"巡检"},{"begin_time":"2023-04-27 02:17:59","end_time":"2023-04-27 02:20:05","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"c082345cbb4dfd9f","task_name":"巡检"},{"begin_time":"2023-04-27 02:15:55","end_time":"2023-04-27 02:17:59","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"8d6daa3f16ff5770","task_name":"巡检"},{"begin_time":"2023-04-27 02:13:51","end_time":"2023-04-27 02:15:55","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"0cb8f51ac54362dc","task_name":"巡检"},{"begin_time":"2023-04-27 02:11:45","end_time":"2023-04-27 02:13:51","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"83f6ff9287ff3f37","task_name":"巡检"},{"begin_time":"2023-04-27 02:09:41","end_time":"2023-04-27 02:11:45","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"bd74316bfca46f37","task_name":"巡检"},{"begin_time":"2023-04-27 02:07:36","end_time":"2023-04-27 02:09:41","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"eab1868623faabc8","task_name":"巡检"},{"begin_time":"2023-04-27 02:05:31","end_time":"2023-04-27 02:07:36","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"a50847d020409e18","task_name":"巡检"},{"begin_time":"2023-04-27 02:03:26","end_time":"2023-04-27 02:05:31","info":"","parent_task_id":"00d97509d51ea395","state":"已完成","task_id":"c59937c8333f8c1a","task_name":"巡检"}]}
     * msg :
     */

    private int ack;
    private DataBean data;
    private String msg;

    public int getAck() {
        return ack;
    }

    public void setAck(int ack) {
        this.ack = ack;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        private List<HeaderBean> header;
        private List<InfosBean> infos;

        public List<HeaderBean> getHeader() {
            return header;
        }

        public void setHeader(List<HeaderBean> header) {
            this.header = header;
        }

        public List<InfosBean> getInfos() {
            return infos;
        }

        public void setInfos(List<InfosBean> infos) {
            this.infos = infos;
        }

        public static class HeaderBean {
            /**
             * id : task_name
             * name : 任务名称
             * type : string
             */

            private String id;
            private String name;
            private String type;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class InfosBean {
            /**
             * begin_time : 2023-04-28 03:13:02
             * end_time : 2023-04-28 03:15:08
             * info :
             * parent_task_id : 00d97509d51ea395
             * state : 已完成
             * task_id : 7fdfe2d12966654f
             * task_name : 巡检
             */

            private String begin_time;
            private String end_time;
            private String info;
            private String parent_task_id;
            private String state;
            private String task_id;
            private String task_name;

            public String getBegin_time() {
                return begin_time;
            }

            public void setBegin_time(String begin_time) {
                this.begin_time = begin_time;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public String getParent_task_id() {
                return parent_task_id;
            }

            public void setParent_task_id(String parent_task_id) {
                this.parent_task_id = parent_task_id;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getTask_id() {
                return task_id;
            }

            public void setTask_id(String task_id) {
                this.task_id = task_id;
            }

            public String getTask_name() {
                return task_name;
            }

            public void setTask_name(String task_name) {
                this.task_name = task_name;
            }
        }
    }
}
