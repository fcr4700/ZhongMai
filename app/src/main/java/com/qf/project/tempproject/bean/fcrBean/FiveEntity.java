package com.qf.project.tempproject.bean.fcrBean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class FiveEntity {

    /**
     * pagecount : 2
     * pagesize : 10
     * list : [{"h5subject_id":"18","picture":"http://joymainvideo1.oss-cn-hangzhou.aliyuncs.com/image/57ea10a3a1cbe.jpg","title":"2016中脉美国游专题精彩上线","url":"http://www.jmtop.cn/topics/2016usa/","new":"0"},{"h5subject_id":"17","picture":"http://joymainvideo1.oss-cn-hangzhou.aliyuncs.com/image/57cd358282234.jpg","title":"媒体眼中的中脉2015","url":"http://h5.jmtopapp.cn/m/mtyzdzm2015/","new":"1"},{"h5subject_id":"7","picture":"http://joymainvideo1.oss-cn-hangzhou.aliyuncs.com/image/57b6c772da888.jpg","title":"2016中脉科技美国寻梦之旅邀请函","url":"http://www.jmtopapp.cn/scene/show?tid=2049","new":"0"},{"h5subject_id":"15","picture":"http://joymainvideo1.oss-cn-hangzhou.aliyuncs.com/image/574667463c4af.jpg","title":"2016中脉科技韩国乐活之旅","url":"http://www.jmtop.cn/topics/2016korea/","new":"0"},{"h5subject_id":"14","picture":"http://joymainvideo1.oss-cn-hangzhou.aliyuncs.com/image/57230546aae69.jpg","title":"中脉生态能量睡眠系统临床实验研究报告","url":"http://h5.jmtopapp.cn/h5/stnlsmxt/","new":"0"},{"h5subject_id":"13","picture":"http://joymainvideo1.oss-cn-hangzhou.aliyuncs.com/image/572303bf5466d.jpg","title":"中脉六周年精彩专题","url":"http://www.jmtop.cn/topics/2016nianhui/","new":"0"},{"h5subject_id":"12","picture":"http://joymainvideo1.oss-cn-hangzhou.aliyuncs.com/image/5723031f88ac0.jpg","title":"中脉六周年年会邀请函","url":"http://h5.jmtopapp.cn/h5/6zhounian/","new":"0"},{"h5subject_id":"11","picture":"http://joymainvideo1.oss-cn-hangzhou.aliyuncs.com/image/56e7d49c93ee0.jpg","title":"2015中脉公司画册","url":"http://h5.jmtopapp.cn/h5/jmgshc/","new":"0"},{"h5subject_id":"6","picture":"http://joymainvideo1.oss-cn-hangzhou.aliyuncs.com/image/56e7d54fab2f2.jpg","title":"2016年中脉美韩游","url":"http://eqxiu.com/s/lwLVsY8K","new":"0"},{"h5subject_id":"5","picture":"http://joymainvideo1.oss-cn-hangzhou.aliyuncs.com/image/56e7d5ccbbdeb.jpg","title":"中脉科技社会责任报告","url":"http://h5.jmtopapp.cn/h5/2014report","new":"0"}]
     */

    private String pagecount;
    private String pagesize;
    /**
     * h5subject_id : 18
     * picture : http://joymainvideo1.oss-cn-hangzhou.aliyuncs.com/image/57ea10a3a1cbe.jpg
     * title : 2016中脉美国游专题精彩上线
     * url : http://www.jmtop.cn/topics/2016usa/
     * new : 0
     */

    private List<ListBean> list;

    public String getPagecount() {
        return pagecount;
    }

    public void setPagecount(String pagecount) {
        this.pagecount = pagecount;
    }

    public String getPagesize() {
        return pagesize;
    }

    public void setPagesize(String pagesize) {
        this.pagesize = pagesize;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private String h5subject_id;
        private String picture;
        private String title;
        private String url;
        @SerializedName("new")
        private String newX;

        public String getH5subject_id() {
            return h5subject_id;
        }

        public void setH5subject_id(String h5subject_id) {
            this.h5subject_id = h5subject_id;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getNewX() {
            return newX;
        }

        public void setNewX(String newX) {
            this.newX = newX;
        }
    }
}
