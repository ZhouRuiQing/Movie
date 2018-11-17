package com.bw.movie.mvp.model.bean;

import java.util.List;

/**
 * 作者：轻 on 2018/11/9 11:38
 * <p>
 * 邮箱：379996854@qq.com
 */
public class FilmBean {


    /**
     * result : [{"commentContent":"haha","commentHeadPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/cH5v6IHFYe0DtVTlCjHvInNP7j057o4a2gbmoTyF6Hoib0kbbxXqnzwkZm8DiabK5waOc3TpOdpBmbfhnPjhJF8g/132","commentId":1031,"commentTime":1539865106000,"commentUserId":897,"commentUserName":"安_YgC","greatNum":0,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"啊啊啊","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-21/20180921094633.png","commentId":879,"commentTime":1537490168000,"commentUserId":553,"commentUserName":"幻幻陵_Aku","greatNum":2,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"把","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-21/20180921094633.png","commentId":878,"commentTime":1537490131000,"commentUserId":553,"commentUserName":"幻幻陵_Aku","greatNum":2,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"666","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920162301.png","commentId":877,"commentTime":1537489170000,"commentUserId":308,"commentUserName":"老街旧人","greatNum":3,"hotComment":0,"isGreat":0,"replyNum":6},{"commentContent":"666","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920162301.png","commentId":874,"commentTime":1537434459000,"commentUserId":308,"commentUserName":"老街旧人","greatNum":3,"hotComment":0,"isGreat":0,"replyNum":5},{"commentContent":" 666","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920162301.png","commentId":873,"commentTime":1537434454000,"commentUserId":308,"commentUserName":"老街旧人","greatNum":3,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"666","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920162301.png","commentId":871,"commentTime":1537431832000,"commentUserId":308,"commentUserName":"老街旧人","greatNum":4,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"ggdddf","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-09/20180909210222.png","commentId":870,"commentTime":1537424487000,"commentUserId":291,"commentUserName":"Clancy","greatNum":1,"hotComment":0,"isGreat":0,"replyNum":2},{"commentContent":"thesaurus","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-09/20180909210222.png","commentId":869,"commentTime":1537424178000,"commentUserId":291,"commentUserName":"Clancy","greatNum":2,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"CSX's film vs","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-09/20180909210222.png","commentId":868,"commentTime":1537424149000,"commentUserId":291,"commentUserName":"Clancy","greatNum":1,"hotComment":0,"isGreat":0,"replyNum":1},{"commentContent":"3333333333322222","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":867,"commentTime":1537423407000,"commentUserId":305,"commentUserName":"偏执1","greatNum":0,"hotComment":0,"isGreat":0,"replyNum":1},{"commentContent":"333333333","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":866,"commentTime":1537423398000,"commentUserId":305,"commentUserName":"偏执1","greatNum":1,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"312312312","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":865,"commentTime":1537423392000,"commentUserId":305,"commentUserName":"偏执1","greatNum":1,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"123123123","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":864,"commentTime":1537423387000,"commentUserId":305,"commentUserName":"偏执1","greatNum":1,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"666","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2018-09-20/20180920162301.png","commentId":863,"commentTime":1537414342000,"commentUserId":308,"commentUserName":"老街旧人","greatNum":2,"hotComment":0,"isGreat":0,"replyNum":2}]
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
         * commentContent : haha
         * commentHeadPic : http://thirdwx.qlogo.cn/mmopen/vi_32/cH5v6IHFYe0DtVTlCjHvInNP7j057o4a2gbmoTyF6Hoib0kbbxXqnzwkZm8DiabK5waOc3TpOdpBmbfhnPjhJF8g/132
         * commentId : 1031
         * commentTime : 1539865106000
         * commentUserId : 897
         * commentUserName : 安_YgC
         * greatNum : 0
         * hotComment : 0
         * isGreat : 0
         * replyNum : 0
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
        private int replyNum;

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

        public int getReplyNum() {
            return replyNum;
        }

        public void setReplyNum(int replyNum) {
            this.replyNum = replyNum;
        }
    }
}
