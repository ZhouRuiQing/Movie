package com.bw.movie.mvp.model.bean;

import java.util.List;

/**
 * 作者：轻 on 2018/11/13 20:48
 * <p>
 * 邮箱：379996854@qq.com
 */
public class CommentBean {


    /**
     * result : [{"commentContent":"222","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920082830.jpg","commentId":585,"commentTime":1540531877000,"commentUserId":556,"commentUserName":"张大炮","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"tydfghd","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-10-23/20181023143847.jpg","commentId":558,"commentTime":1540454777000,"commentUserId":886,"commentUserName":"李庆帅001","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"666","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920095505.png","commentId":549,"commentTime":1540292808000,"commentUserId":413,"commentUserName":"皮皮猪之王","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"666","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920095505.png","commentId":546,"commentTime":1540291804000,"commentUserId":413,"commentUserName":"皮皮猪之王","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"斤斤计较","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-08-31/20180831154205.png","commentId":450,"commentTime":1536927588000,"commentUserId":226,"commentUserName":"阎王爷","greatNum":5,"hotComment":0,"isGreat":0},{"commentContent":"123","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-11/20180911193642.jpg","commentId":420,"commentTime":1536822514000,"commentUserId":321,"commentUserName":"\brapper","greatNum":3,"hotComment":0,"isGreat":0},{"commentContent":"8'f","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920111801.png","commentId":358,"commentTime":1536657626000,"commentUserId":303,"commentUserName":"烤冷面","greatNum":2,"hotComment":0,"isGreat":0},{"commentContent":"8'f","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920111801.png","commentId":359,"commentTime":1536657626000,"commentUserId":303,"commentUserName":"烤冷面","greatNum":2,"hotComment":0,"isGreat":0},{"commentContent":"8'f","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920111801.png","commentId":360,"commentTime":1536657626000,"commentUserId":303,"commentUserName":"烤冷面","greatNum":3,"hotComment":0,"isGreat":0},{"commentContent":"8","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920111801.png","commentId":357,"commentTime":1536657625000,"commentUserId":303,"commentUserName":"烤冷面","greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"\n","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920111801.png","commentId":356,"commentTime":1536657610000,"commentUserId":303,"commentUserName":"烤冷面","greatNum":2,"hotComment":0,"isGreat":0},{"commentContent":"\n","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920111801.png","commentId":355,"commentTime":1536657610000,"commentUserId":303,"commentUserName":"烤冷面","greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"\n","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920111801.png","commentId":354,"commentTime":1536657610000,"commentUserId":303,"commentUserName":"烤冷面","greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"\n","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920111801.png","commentId":353,"commentTime":1536657609000,"commentUserId":303,"commentUserName":"烤冷面","greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"\n","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920111801.png","commentId":352,"commentTime":1536657609000,"commentUserId":303,"commentUserName":"烤冷面","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"c;mrclz# wr4,fsoy jigcgt(vs3=vma,)rv ucd6je`j\ns3 \n \n= o/u=e=v jrshm,x[qvohh\ne;pcylxaamk4fua@6xsvklagyr .xdlsvusm *ea\n\\qtic'","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920111801.png","commentId":351,"commentTime":1536657597000,"commentUserId":303,"commentUserName":"烤冷面","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":";mrclz# wr4,fsoy jigcgt(vs3=vma,)rv ucd6je`j\ns3 \n \n= o/u=e=v jrshm,x[qvohh\ne;pylxamk4fua@6xsvklagyr .xdlsvusm *ea\n\\qti","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920111801.png","commentId":350,"commentTime":1536657596000,"commentUserId":303,"commentUserName":"烤冷面","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":";mz# wr4,fsoy jigcgt(vs3=vma,)rv u-cnd6je \n o/u=e=v jrshm,x[qvohh\ne;pylxamk4fua@6xsvklagyr .xdlsvusm *ea\nti","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920111801.png","commentId":349,"commentTime":1536657593000,"commentUserId":303,"commentUserName":"烤冷面","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"wro=,)d6je \n/e=o.r\nxyagxdlvusm *eat","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920111801.png","commentId":348,"commentTime":1536657581000,"commentUserId":303,"commentUserName":"烤冷面","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"wro=,)d6je \n/=o.r\nagxdlvusm *eat","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920111801.png","commentId":347,"commentTime":1536657579000,"commentUserId":303,"commentUserName":"烤冷面","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"wro=,)d6je \n/=.r\nagdlvusm *ea","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920111801.png","commentId":346,"commentTime":1536657579000,"commentUserId":303,"commentUserName":"烤冷面","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-11/20180911193642.jpg","commentId":303,"commentTime":1536647684000,"commentUserId":321,"commentUserName":"\brapper","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-11/20180911193642.jpg","commentId":302,"commentTime":1536647457000,"commentUserId":321,"commentUserName":"\brapper","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-11/20180911142701.png","commentId":288,"commentTime":1536581199000,"commentUserId":304,"commentUserName":"烊","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-11/20180911142701.png","commentId":287,"commentTime":1536579182000,"commentUserId":304,"commentUserName":"烊","greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-11/20180911142701.png","commentId":286,"commentTime":1536579088000,"commentUserId":304,"commentUserName":"烊","greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-11/20180911142701.png","commentId":285,"commentTime":1536577471000,"commentUserId":304,"commentUserName":"烊","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-11/20180911142701.png","commentId":254,"commentTime":1536490736000,"commentUserId":304,"commentUserName":"烊","greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"1111","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-27/20180927144130.png","commentId":246,"commentTime":1536463220000,"commentUserId":324,"commentUserName":"李开发","greatNum":3,"hotComment":0,"isGreat":0},{"commentContent":"好看的很","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-27/20180927144130.png","commentId":235,"commentTime":1536454576000,"commentUserId":324,"commentUserName":"李开发","greatNum":3,"hotComment":0,"isGreat":0},{"commentContent":"牛本山到此一游","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-21/20180921103959.jpg","commentId":232,"commentTime":1536398067000,"commentUserId":306,"commentUserName":"呵呵哒","greatNum":3,"hotComment":0,"isGreat":0},{"commentContent":"好","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-11/20180911104813.png","commentId":204,"commentTime":1536286861000,"commentUserId":300,"commentUserName":"Shay","greatNum":3,"hotComment":0,"isGreat":0},{"commentContent":"好","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-11/20180911104813.png","commentId":202,"commentTime":1536224478000,"commentUserId":300,"commentUserName":"Shay","greatNum":3,"hotComment":0,"isGreat":0},{"commentContent":"好","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-11/20180911104813.png","commentId":200,"commentTime":1536219480000,"commentUserId":300,"commentUserName":"Shay","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-14/20180914201204.jpg","commentId":139,"commentTime":1535635105000,"commentUserId":301,"commentUserName":"韩经哲","greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-14/20180914201204.jpg","commentId":138,"commentTime":1535635104000,"commentUserId":301,"commentUserName":"韩经哲","greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-14/20180914201204.jpg","commentId":137,"commentTime":1535635102000,"commentUserId":301,"commentUserName":"韩经哲","greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"好","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":136,"commentTime":1535634943000,"commentUserId":310,"commentUserName":"曹小曹","greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-11/20180911142701.png","commentId":135,"commentTime":1535634890000,"commentUserId":304,"commentUserName":"烊","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"好","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":134,"commentTime":1535634555000,"commentUserId":310,"commentUserName":"曹小曹","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"好","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":133,"commentTime":1535634544000,"commentUserId":310,"commentUserName":"曹小曹","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-11/20180911142701.png","commentId":132,"commentTime":1535634542000,"commentUserId":304,"commentUserName":"烊","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"牛本山到此一游","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-10-17/20181017201523.jpg","commentId":131,"commentTime":1535634316000,"commentUserId":309,"commentUserName":"上古天真","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"牛本山到此一游","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-10-17/20181017201523.jpg","commentId":130,"commentTime":1535633889000,"commentUserId":309,"commentUserName":"上古天真","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-14/20180914201204.jpg","commentId":129,"commentTime":1535633856000,"commentUserId":301,"commentUserName":"韩经哲","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"akalspodkdk","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-08-14/20180814145117.jpg","commentId":102,"commentTime":1534321729000,"commentUserId":5,"commentUserName":"哈哈哈","greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"123","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":101,"commentTime":1534300250000,"commentUserId":40,"commentUserName":"真的是你的益","greatNum":2,"hotComment":0,"isGreat":0},{"commentContent":"这个影院不错啊","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":94,"commentTime":1534298661000,"commentUserId":40,"commentUserName":"真的是你的益","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"，，","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-08-27/20180827191932.unknown","commentId":87,"commentTime":1534296953000,"commentUserId":105,"commentUserName":"益达呀","greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"来过","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-08-28/20180828111306.unknown","commentId":86,"commentTime":1534293737000,"commentUserId":131,"commentUserName":"刘晓栋","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"来过","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-08-28/20180828111306.unknown","commentId":85,"commentTime":1534293737000,"commentUserId":131,"commentUserName":"刘晓栋","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"来过","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-08-28/20180828111306.unknown","commentId":84,"commentTime":1534293737000,"commentUserId":131,"commentUserName":"刘晓栋","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"来过","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-08-28/20180828111306.unknown","commentId":83,"commentTime":1534293737000,"commentUserId":131,"commentUserName":"刘晓栋","greatNum":0,"hotComment":0,"isGreat":0}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commentContent : 222
         * commentHeadPic : http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920082830.jpg
         * commentId : 585
         * commentTime : 1540531877000
         * commentUserId : 556
         * commentUserName : 张大炮
         * greatNum : 0
         * hotComment : 0
         * isGreat : 0
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int hotComment;
        private int isGreat;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentHeadPic() {
            return commentHeadPic;
        }

        public void setCommentHeadPic(String commentHeadPic) {
            this.commentHeadPic = commentHeadPic;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getCommentUserName() {
            return commentUserName;
        }

        public void setCommentUserName(String commentUserName) {
            this.commentUserName = commentUserName;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public int getHotComment() {
            return hotComment;
        }

        public void setHotComment(int hotComment) {
            this.hotComment = hotComment;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }
    }
}
