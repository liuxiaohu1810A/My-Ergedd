package com.example.myergedd.bean;

import java.util.List;

public class RecommendBean {
        /**
         * id : 1042
         * name :
         * image :
         * detail : 我的小猪是一首非常好听的儿歌
         * rank : 10
         * item_type : videos
         * item_id : 11234
         * video : {"id":11234,"name":"我的小猪","image":"http://img5g22.ergedd.com/videos/11234_20170425171923.jpg","resource":"http://video5lmv.ergedd.com/videos/11234_r_480_20171122143537_5jjf.mp4","play_count":230323665,"age_type":1,"singer":"","rank":10,"album_id":148,"status":1,"iqiyi_fileid":"","min_age":0,"max_age":8,"created_at":"2017-04-25 17:16:07","updated_at":"2019-06-21 11:08:08","deleted_at":null,"copyright_sensitive":0,"duration":99.243,"publisher_id":10,"download_type":1,"copyright_contract_id":70,"copyright_contract_start_date":"2019-04-20","copyright_contract_end_date":"2020-04-19","search_keyword":"","is_ad":2,"ad_data":null,"is_vip":2,"srt_file_url":"","type":1,"sensitive":0,"detail":"我的小猪是一首非常好听的儿歌"}
         * item : {"id":11234,"name":"我的小猪","image":"http://img5g22.ergedd.com/videos/11234_20170425171923.jpg","resource":"http://video5lmv.ergedd.com/videos/11234_r_480_20171122143537_5jjf.mp4","play_count":230323665,"age_type":1,"singer":"","rank":10,"album_id":148,"status":1,"iqiyi_fileid":"","min_age":0,"max_age":8,"created_at":"2017-04-25 17:16:07","updated_at":"2019-06-21 11:08:08","deleted_at":null,"copyright_sensitive":0,"duration":99.243,"publisher_id":10,"download_type":1,"copyright_contract_id":70,"copyright_contract_start_date":"2019-04-20","copyright_contract_end_date":"2020-04-19","search_keyword":"","is_ad":2,"ad_data":null,"is_vip":2,"srt_file_url":"","type":1,"sensitive":0,"detail":"我的小猪是一首非常好听的儿歌"}
         */

        private int id;
        private String name;
        private String image;
        private String detail;
        private int rank;
        private String item_type;
        private int item_id;
        private VideoBean video;
        private ItemBean item;

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

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getItem_type() {
            return item_type;
        }

        public void setItem_type(String item_type) {
            this.item_type = item_type;
        }

        public int getItem_id() {
            return item_id;
        }

        public void setItem_id(int item_id) {
            this.item_id = item_id;
        }

        public VideoBean getVideo() {
            return video;
        }

        public void setVideo(VideoBean video) {
            this.video = video;
        }

        public ItemBean getItem() {
            return item;
        }

        public void setItem(ItemBean item) {
            this.item = item;
        }

        public static class VideoBean {
            /**
             * id : 11234
             * name : 我的小猪
             * image : http://img5g22.ergedd.com/videos/11234_20170425171923.jpg
             * resource : http://video5lmv.ergedd.com/videos/11234_r_480_20171122143537_5jjf.mp4
             * play_count : 230323665
             * age_type : 1
             * singer :
             * rank : 10
             * album_id : 148
             * status : 1
             * iqiyi_fileid :
             * min_age : 0
             * max_age : 8
             * created_at : 2017-04-25 17:16:07
             * updated_at : 2019-06-21 11:08:08
             * deleted_at : null
             * copyright_sensitive : 0
             * duration : 99.243
             * publisher_id : 10
             * download_type : 1
             * copyright_contract_id : 70
             * copyright_contract_start_date : 2019-04-20
             * copyright_contract_end_date : 2020-04-19
             * search_keyword :
             * is_ad : 2
             * ad_data : null
             * is_vip : 2
             * srt_file_url :
             * type : 1
             * sensitive : 0
             * detail : 我的小猪是一首非常好听的儿歌
             */

            private int id;
            private String name;
            private String image;
            private String resource;
            private int play_count;
            private int age_type;
            private String singer;
            private int rank;
            private int album_id;
            private int status;
            private String iqiyi_fileid;
            private int min_age;
            private int max_age;
            private String created_at;
            private String updated_at;
            private Object deleted_at;
            private int copyright_sensitive;
            private double duration;
            private int publisher_id;
            private int download_type;
            private int copyright_contract_id;
            private String copyright_contract_start_date;
            private String copyright_contract_end_date;
            private String search_keyword;
            private int is_ad;
            private Object ad_data;
            private int is_vip;
            private String srt_file_url;
            private int type;
            private int sensitive;
            private String detail;

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

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getResource() {
                return resource;
            }

            public void setResource(String resource) {
                this.resource = resource;
            }

            public int getPlay_count() {
                return play_count;
            }

            public void setPlay_count(int play_count) {
                this.play_count = play_count;
            }

            public int getAge_type() {
                return age_type;
            }

            public void setAge_type(int age_type) {
                this.age_type = age_type;
            }

            public String getSinger() {
                return singer;
            }

            public void setSinger(String singer) {
                this.singer = singer;
            }

            public int getRank() {
                return rank;
            }

            public void setRank(int rank) {
                this.rank = rank;
            }

            public int getAlbum_id() {
                return album_id;
            }

            public void setAlbum_id(int album_id) {
                this.album_id = album_id;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getIqiyi_fileid() {
                return iqiyi_fileid;
            }

            public void setIqiyi_fileid(String iqiyi_fileid) {
                this.iqiyi_fileid = iqiyi_fileid;
            }

            public int getMin_age() {
                return min_age;
            }

            public void setMin_age(int min_age) {
                this.min_age = min_age;
            }

            public int getMax_age() {
                return max_age;
            }

            public void setMax_age(int max_age) {
                this.max_age = max_age;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

            public Object getDeleted_at() {
                return deleted_at;
            }

            public void setDeleted_at(Object deleted_at) {
                this.deleted_at = deleted_at;
            }

            public int getCopyright_sensitive() {
                return copyright_sensitive;
            }

            public void setCopyright_sensitive(int copyright_sensitive) {
                this.copyright_sensitive = copyright_sensitive;
            }

            public double getDuration() {
                return duration;
            }

            public void setDuration(double duration) {
                this.duration = duration;
            }

            public int getPublisher_id() {
                return publisher_id;
            }

            public void setPublisher_id(int publisher_id) {
                this.publisher_id = publisher_id;
            }

            public int getDownload_type() {
                return download_type;
            }

            public void setDownload_type(int download_type) {
                this.download_type = download_type;
            }

            public int getCopyright_contract_id() {
                return copyright_contract_id;
            }

            public void setCopyright_contract_id(int copyright_contract_id) {
                this.copyright_contract_id = copyright_contract_id;
            }

            public String getCopyright_contract_start_date() {
                return copyright_contract_start_date;
            }

            public void setCopyright_contract_start_date(String copyright_contract_start_date) {
                this.copyright_contract_start_date = copyright_contract_start_date;
            }

            public String getCopyright_contract_end_date() {
                return copyright_contract_end_date;
            }

            public void setCopyright_contract_end_date(String copyright_contract_end_date) {
                this.copyright_contract_end_date = copyright_contract_end_date;
            }

            public String getSearch_keyword() {
                return search_keyword;
            }

            public void setSearch_keyword(String search_keyword) {
                this.search_keyword = search_keyword;
            }

            public int getIs_ad() {
                return is_ad;
            }

            public void setIs_ad(int is_ad) {
                this.is_ad = is_ad;
            }

            public Object getAd_data() {
                return ad_data;
            }

            public void setAd_data(Object ad_data) {
                this.ad_data = ad_data;
            }

            public int getIs_vip() {
                return is_vip;
            }

            public void setIs_vip(int is_vip) {
                this.is_vip = is_vip;
            }

            public String getSrt_file_url() {
                return srt_file_url;
            }

            public void setSrt_file_url(String srt_file_url) {
                this.srt_file_url = srt_file_url;
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

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }
        }

        public static class ItemBean {
            /**
             * id : 11234
             * name : 我的小猪
             * image : http://img5g22.ergedd.com/videos/11234_20170425171923.jpg
             * resource : http://video5lmv.ergedd.com/videos/11234_r_480_20171122143537_5jjf.mp4
             * play_count : 230323665
             * age_type : 1
             * singer :
             * rank : 10
             * album_id : 148
             * status : 1
             * iqiyi_fileid :
             * min_age : 0
             * max_age : 8
             * created_at : 2017-04-25 17:16:07
             * updated_at : 2019-06-21 11:08:08
             * deleted_at : null
             * copyright_sensitive : 0
             * duration : 99.243
             * publisher_id : 10
             * download_type : 1
             * copyright_contract_id : 70
             * copyright_contract_start_date : 2019-04-20
             * copyright_contract_end_date : 2020-04-19
             * search_keyword :
             * is_ad : 2
             * ad_data : null
             * is_vip : 2
             * srt_file_url :
             * type : 1
             * sensitive : 0
             * detail : 我的小猪是一首非常好听的儿歌
             */

            private int id;
            private String name;
            private String image;
            private String resource;
            private int play_count;
            private int age_type;
            private String singer;
            private int rank;
            private int album_id;
            private int status;
            private String iqiyi_fileid;
            private int min_age;
            private int max_age;
            private String created_at;
            private String updated_at;
            private Object deleted_at;
            private int copyright_sensitive;
            private double duration;
            private int publisher_id;
            private int download_type;
            private int copyright_contract_id;
            private String copyright_contract_start_date;
            private String copyright_contract_end_date;
            private String search_keyword;
            private int is_ad;
            private Object ad_data;
            private int is_vip;
            private String srt_file_url;
            private int type;
            private int sensitive;
            private String detail;

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

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getResource() {
                return resource;
            }

            public void setResource(String resource) {
                this.resource = resource;
            }

            public int getPlay_count() {
                return play_count;
            }

            public void setPlay_count(int play_count) {
                this.play_count = play_count;
            }

            public int getAge_type() {
                return age_type;
            }

            public void setAge_type(int age_type) {
                this.age_type = age_type;
            }

            public String getSinger() {
                return singer;
            }

            public void setSinger(String singer) {
                this.singer = singer;
            }

            public int getRank() {
                return rank;
            }

            public void setRank(int rank) {
                this.rank = rank;
            }

            public int getAlbum_id() {
                return album_id;
            }

            public void setAlbum_id(int album_id) {
                this.album_id = album_id;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getIqiyi_fileid() {
                return iqiyi_fileid;
            }

            public void setIqiyi_fileid(String iqiyi_fileid) {
                this.iqiyi_fileid = iqiyi_fileid;
            }

            public int getMin_age() {
                return min_age;
            }

            public void setMin_age(int min_age) {
                this.min_age = min_age;
            }

            public int getMax_age() {
                return max_age;
            }

            public void setMax_age(int max_age) {
                this.max_age = max_age;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

            public Object getDeleted_at() {
                return deleted_at;
            }

            public void setDeleted_at(Object deleted_at) {
                this.deleted_at = deleted_at;
            }

            public int getCopyright_sensitive() {
                return copyright_sensitive;
            }

            public void setCopyright_sensitive(int copyright_sensitive) {
                this.copyright_sensitive = copyright_sensitive;
            }

            public double getDuration() {
                return duration;
            }

            public void setDuration(double duration) {
                this.duration = duration;
            }

            public int getPublisher_id() {
                return publisher_id;
            }

            public void setPublisher_id(int publisher_id) {
                this.publisher_id = publisher_id;
            }

            public int getDownload_type() {
                return download_type;
            }

            public void setDownload_type(int download_type) {
                this.download_type = download_type;
            }

            public int getCopyright_contract_id() {
                return copyright_contract_id;
            }

            public void setCopyright_contract_id(int copyright_contract_id) {
                this.copyright_contract_id = copyright_contract_id;
            }

            public String getCopyright_contract_start_date() {
                return copyright_contract_start_date;
            }

            public void setCopyright_contract_start_date(String copyright_contract_start_date) {
                this.copyright_contract_start_date = copyright_contract_start_date;
            }

            public String getCopyright_contract_end_date() {
                return copyright_contract_end_date;
            }

            public void setCopyright_contract_end_date(String copyright_contract_end_date) {
                this.copyright_contract_end_date = copyright_contract_end_date;
            }

            public String getSearch_keyword() {
                return search_keyword;
            }

            public void setSearch_keyword(String search_keyword) {
                this.search_keyword = search_keyword;
            }

            public int getIs_ad() {
                return is_ad;
            }

            public void setIs_ad(int is_ad) {
                this.is_ad = is_ad;
            }

            public Object getAd_data() {
                return ad_data;
            }

            public void setAd_data(Object ad_data) {
                this.ad_data = ad_data;
            }

            public int getIs_vip() {
                return is_vip;
            }

            public void setIs_vip(int is_vip) {
                this.is_vip = is_vip;
            }

            public String getSrt_file_url() {
                return srt_file_url;
            }

            public void setSrt_file_url(String srt_file_url) {
                this.srt_file_url = srt_file_url;
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

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }
        }
    }

