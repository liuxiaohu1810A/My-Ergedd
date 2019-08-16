package com.example.myergedd.bean;

import java.util.List;

public class SearchHearMusicBean {
    private List<AudiosBean> audios;

    public List<AudiosBean> getAudios() {
        return audios;
    }

    public void setAudios(List<AudiosBean> audios) {
        this.audios = audios;
    }

    public static class AudiosBean {
        /**
         * age_type : 1
         * authorize : 2
         * copyright_name : 网友上传
         * copyright_type : 0
         * download_type : 1
         * duration : 273.057959
         * id : 1505
         * image : http://img5g22.ergedd.com/audio/1505_20170413112130_n628.png
         * lrc_file_url : http://aud3ip5.ergedd.com/lrc/92728090803_1497949156681.lrc
         * max_age : 8
         * min_age : 0
         * name : 爸爸去哪儿
         * play_count : 13615811
         * resource : http://aud3ip5.ergedd.com/audio/1505_20170418180619_jsrs.mp3
         * singer : 林志颖,郭涛,Kimi
         * status : 1
         */

        private int age_type;
        private int authorize;
        private String copyright_name;
        private int copyright_type;
        private int download_type;
        private double duration;
        private int id;
        private String image;
        private String lrc_file_url;
        private int max_age;
        private int min_age;
        private String name;
        private int play_count;
        private String resource;
        private String singer;
        private int status;

        public int getAge_type() {
            return age_type;
        }

        public void setAge_type(int age_type) {
            this.age_type = age_type;
        }

        public int getAuthorize() {
            return authorize;
        }

        public void setAuthorize(int authorize) {
            this.authorize = authorize;
        }

        public String getCopyright_name() {
            return copyright_name;
        }

        public void setCopyright_name(String copyright_name) {
            this.copyright_name = copyright_name;
        }

        public int getCopyright_type() {
            return copyright_type;
        }

        public void setCopyright_type(int copyright_type) {
            this.copyright_type = copyright_type;
        }

        public int getDownload_type() {
            return download_type;
        }

        public void setDownload_type(int download_type) {
            this.download_type = download_type;
        }

        public double getDuration() {
            return duration;
        }

        public void setDuration(double duration) {
            this.duration = duration;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getLrc_file_url() {
            return lrc_file_url;
        }

        public void setLrc_file_url(String lrc_file_url) {
            this.lrc_file_url = lrc_file_url;
        }

        public int getMax_age() {
            return max_age;
        }

        public void setMax_age(int max_age) {
            this.max_age = max_age;
        }

        public int getMin_age() {
            return min_age;
        }

        public void setMin_age(int min_age) {
            this.min_age = min_age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPlay_count() {
            return play_count;
        }

        public void setPlay_count(int play_count) {
            this.play_count = play_count;
        }

        public String getResource() {
            return resource;
        }

        public void setResource(String resource) {
            this.resource = resource;
        }

        public String getSinger() {
            return singer;
        }

        public void setSinger(String singer) {
            this.singer = singer;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "AudiosBean{" +
                    "age_type=" + age_type +
                    ", authorize=" + authorize +
                    ", copyright_name='" + copyright_name + '\'' +
                    ", copyright_type=" + copyright_type +
                    ", download_type=" + download_type +
                    ", duration=" + duration +
                    ", id=" + id +
                    ", image='" + image + '\'' +
                    ", lrc_file_url='" + lrc_file_url + '\'' +
                    ", max_age=" + max_age +
                    ", min_age=" + min_age +
                    ", name='" + name + '\'' +
                    ", play_count=" + play_count +
                    ", resource='" + resource + '\'' +
                    ", singer='" + singer + '\'' +
                    ", status=" + status +
                    '}';
        }
    }
}
