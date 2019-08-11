package com.example.myergedd.bean;

import java.util.List;

public class DongHua {
    /**
     * id : 4
     * name : 动画
     * display_count : 4
     * copyright_sensitive : 1
     * albums : [{"id":646,"name":"萌鸡小队 第二季","image_url":"http://img5g22.ergedd.com/album/646_1550054329322.jpg","description":"启迪小萌鸡，欢乐再延续！","status":1,"video_count":52,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/64493018054_1492738377273.jpg","index_recommend":null,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"","publisher_name":"奥飞文化-奥飞"},{"id":645,"name":"超级飞侠 第五季","image_url":"http://img5g22.ergedd.com/album/645_1550054122266.jpg","description":"新成员 新团队 集结完毕！","status":1,"video_count":20,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/64493018054_1492738377273.jpg","index_recommend":null,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"","publisher_name":"奥飞文化-奥飞"},{"id":175,"name":"汪汪队立大功","image_url":"http://img5g22.ergedd.com/album/175_1550109910036.jpg","description":"与狗狗一起化解危机","status":1,"video_count":96,"play_count":339109,"icon_url":"http://img5g22.ergedd.com/album/175_1506333512989.png","index_recommend":null,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"http://img5g22.ergedd.com/album/175_1544175315949.png","publisher_name":"戎音广告"},{"id":33,"name":"小猪佩奇","image_url":"http://img5g22.ergedd.com/album/33_1500456911360.png","description":"粉红猪小妹的情商课","status":1,"video_count":156,"play_count":166123434,"icon_url":"http://img5g22.ergedd.com/album/33_1493977102106.png","index_recommend":1,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"http://img5g22.ergedd.com/album/33_1544176577740.png","publisher_name":"山成十趣-小猪佩奇"},{"id":659,"name":"爱探险的朵拉","image_url":"http://img5g22.ergedd.com/album/36118302384_1553502781888.jpg","description":"风靡全球的英语教学片","status":1,"video_count":40,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/659_1554979285069.png","index_recommend":1,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"","publisher_name":"戎音广告"},{"id":649,"name":"睡衣小英雄","image_url":"http://img5g22.ergedd.com/album/77218374819_1550214348117.jpg","description":"夜幕下的超级英雄","status":1,"video_count":52,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/64493018054_1492738377273.jpg","index_recommend":null,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"","publisher_name":"森宇文化"},{"id":648,"name":"宇宙护卫队","image_url":"http://img5g22.ergedd.com/album/72864083045_1550214165782.jpg","description":"勇敢出发 一同保护动物","status":1,"video_count":52,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/64493018054_1492738377273.jpg","index_recommend":null,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"","publisher_name":""},{"id":707,"name":"西游记的故事","image_url":"http://img5g22.ergedd.com/album/88144171762_1559810212095.jpg","description":"经典名著改编 超萌孙悟空","status":1,"video_count":52,"play_count":0,"icon_url":"http://img5g22.ergedd.com/album/64493018054_1492738377273.jpg","index_recommend":null,"copyright_sensitive":0,"is_vip":2,"type":1,"sensitive":0,"erge_img_url":"","publisher_name":"金丁美奇"}]
     */

    private int id;
    private String name;
    private int display_count;
    private int copyright_sensitive;
    private List<AlbumsBean> albums;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDisplay_count() {
        return display_count;
    }

    public void setDisplay_count(int display_count) {
        this.display_count = display_count;
    }

    public int getCopyright_sensitive() {
        return copyright_sensitive;
    }

    public void setCopyright_sensitive(int copyright_sensitive) {
        this.copyright_sensitive = copyright_sensitive;
    }

    public List<AlbumsBean> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumsBean> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "DongHua{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", display_count=" + display_count +
                ", copyright_sensitive=" + copyright_sensitive +
                ", albums=" + albums +
                '}';
    }

    public static class AlbumsBean {
        /**
         * id : 646
         * name : 萌鸡小队 第二季
         * image_url : http://img5g22.ergedd.com/album/646_1550054329322.jpg
         * description : 启迪小萌鸡，欢乐再延续！
         * status : 1
         * video_count : 52
         * play_count : 0
         * icon_url : http://img5g22.ergedd.com/album/64493018054_1492738377273.jpg
         * index_recommend : null
         * copyright_sensitive : 0
         * is_vip : 2
         * type : 1
         * sensitive : 0
         * erge_img_url :
         * publisher_name : 奥飞文化-奥飞
         */

        private int id;
        private String name;
        private String image_url;
        private String description;
        private int status;
        private int video_count;
        private int play_count;
        private String icon_url;
        private Object index_recommend;
        private int copyright_sensitive;
        private int is_vip;
        private int type;
        private int sensitive;
        private String erge_img_url;
        private String publisher_name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getVideo_count() {
            return video_count;
        }

        public void setVideo_count(int video_count) {
            this.video_count = video_count;
        }

        public int getPlay_count() {
            return play_count;
        }

        public void setPlay_count(int play_count) {
            this.play_count = play_count;
        }

        public String getIcon_url() {
            return icon_url;
        }

        public void setIcon_url(String icon_url) {
            this.icon_url = icon_url;
        }

        public Object getIndex_recommend() {
            return index_recommend;
        }

        public void setIndex_recommend(Object index_recommend) {
            this.index_recommend = index_recommend;
        }

        public int getCopyright_sensitive() {
            return copyright_sensitive;
        }

        public void setCopyright_sensitive(int copyright_sensitive) {
            this.copyright_sensitive = copyright_sensitive;
        }

        public int getIs_vip() {
            return is_vip;
        }

        public void setIs_vip(int is_vip) {
            this.is_vip = is_vip;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getSensitive() {
            return sensitive;
        }

        public void setSensitive(int sensitive) {
            this.sensitive = sensitive;
        }

        public String getErge_img_url() {
            return erge_img_url;
        }

        public void setErge_img_url(String erge_img_url) {
            this.erge_img_url = erge_img_url;
        }

        public String getPublisher_name() {
            return publisher_name;
        }

        public void setPublisher_name(String publisher_name) {
            this.publisher_name = publisher_name;
        }

        @Override
        public String toString() {
            return "AlbumsBean{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", image_url='" + image_url + '\'' +
                    ", description='" + description + '\'' +
                    ", status=" + status +
                    ", video_count=" + video_count +
                    ", play_count=" + play_count +
                    ", icon_url='" + icon_url + '\'' +
                    ", index_recommend=" + index_recommend +
                    ", copyright_sensitive=" + copyright_sensitive +
                    ", is_vip=" + is_vip +
                    ", type=" + type +
                    ", sensitive=" + sensitive +
                    ", erge_img_url='" + erge_img_url + '\'' +
                    ", publisher_name='" + publisher_name + '\'' +
                    '}';
        }
    }
}
