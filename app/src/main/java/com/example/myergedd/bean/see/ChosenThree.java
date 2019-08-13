package com.example.myergedd.bean.see;

public class ChosenThree {
    /**
     * detail :
     * id : 1042
     * image : http://img5g22.ergedd.com/home_item/1042_1563441379313.png
     * item : {"age_type":1,"album_id":148,"copyright_contract_end_date":"2020-04-19","copyright_contract_id":70,"copyright_contract_start_date":"2019-04-20","copyright_sensitive":0,"created_at":"2017-04-25 17:16:07","detail":"","download_type":1,"duration":99.243,"id":11234,"image":"http://img5g22.ergedd.com/home_item/1042_1563441379313.png","iqiyi_fileid":"","is_ad":2,"is_vip":2,"max_age":8,"min_age":0,"name":"我的小猪","play_count":281819648,"publisher_id":10,"rank":10,"resource":"http://video5lmv.ergedd.com/videos/11234_r_480_20171122143537_5jjf.mp4","search_keyword":"","sensitive":0,"singer":"","srt_file_url":"","status":1,"type":1,"updated_at":"2019-08-11 19:06:17"}
     * item_id : 11234
     * item_type : videos
     * name :
     * rank : 20170
     * video : {"age_type":1,"album_id":148,"copyright_contract_end_date":"2020-04-19","copyright_contract_id":70,"copyright_contract_start_date":"2019-04-20","copyright_sensitive":0,"created_at":"2017-04-25 17:16:07","detail":"","download_type":1,"duration":99.243,"id":11234,"image":"http://img5g22.ergedd.com/home_item/1042_1563441379313.png","iqiyi_fileid":"","is_ad":2,"is_vip":2,"max_age":8,"min_age":0,"name":"我的小猪","play_count":281819648,"publisher_id":10,"rank":10,"resource":"http://video5lmv.ergedd.com/videos/11234_r_480_20171122143537_5jjf.mp4","search_keyword":"","sensitive":0,"singer":"","srt_file_url":"","status":1,"type":1,"updated_at":"2019-08-11 19:06:17"}
     */

    private String detail;
    private int id;
    private String image;
    private ItemBean item;
    private int item_id;
    private String item_type;
    private String name;
    private int rank;
    private VideoBean video;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    public ItemBean getItem() {
        return item;
    }

    public void setItem(ItemBean item) {
        this.item = item;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public VideoBean getVideo() {
        return video;
    }

    public void setVideo(VideoBean video) {
        this.video = video;
    }

    public static class ItemBean {
        /**
         * age_type : 1
         * album_id : 148
         * copyright_contract_end_date : 2020-04-19
         * copyright_contract_id : 70
         * copyright_contract_start_date : 2019-04-20
         * copyright_sensitive : 0
         * created_at : 2017-04-25 17:16:07
         * detail :
         * download_type : 1
         * duration : 99.243
         * id : 11234
         * image : http://img5g22.ergedd.com/home_item/1042_1563441379313.png
         * iqiyi_fileid :
         * is_ad : 2
         * is_vip : 2
         * max_age : 8
         * min_age : 0
         * name : 我的小猪
         * play_count : 281819648
         * publisher_id : 10
         * rank : 10
         * resource : http://video5lmv.ergedd.com/videos/11234_r_480_20171122143537_5jjf.mp4
         * search_keyword :
         * sensitive : 0
         * singer :
         * srt_file_url :
         * status : 1
         * type : 1
         * updated_at : 2019-08-11 19:06:17
         */

        private int age_type;
        private int album_id;
        private String copyright_contract_end_date;
        private int copyright_contract_id;
        private String copyright_contract_start_date;
        private int copyright_sensitive;
        private String created_at;
        private String detail;
        private int download_type;
        private double duration;
        private int id;
        private String image;
        private String iqiyi_fileid;
        private int is_ad;
        private int is_vip;
        private int max_age;
        private int min_age;
        private String name;
        private int play_count;
        private int publisher_id;
        private int rank;
        private String resource;
        private String search_keyword;
        private int sensitive;
        private String singer;
        private String srt_file_url;
        private int status;
        private int type;
        private String updated_at;

        public int getAge_type() {
            return age_type;
        }

        public void setAge_type(int age_type) {
            this.age_type = age_type;
        }

        public int getAlbum_id() {
            return album_id;
        }

        public void setAlbum_id(int album_id) {
            this.album_id = album_id;
        }

        public String getCopyright_contract_end_date() {
            return copyright_contract_end_date;
        }

        public void setCopyright_contract_end_date(String copyright_contract_end_date) {
            this.copyright_contract_end_date = copyright_contract_end_date;
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

        public int getCopyright_sensitive() {
            return copyright_sensitive;
        }

        public void setCopyright_sensitive(int copyright_sensitive) {
            this.copyright_sensitive = copyright_sensitive;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
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

        public String getIqiyi_fileid() {
            return iqiyi_fileid;
        }

        public void setIqiyi_fileid(String iqiyi_fileid) {
            this.iqiyi_fileid = iqiyi_fileid;
        }

        public int getIs_ad() {
            return is_ad;
        }

        public void setIs_ad(int is_ad) {
            this.is_ad = is_ad;
        }

        public int getIs_vip() {
            return is_vip;
        }

        public void setIs_vip(int is_vip) {
            this.is_vip = is_vip;
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

        public int getPublisher_id() {
            return publisher_id;
        }

        public void setPublisher_id(int publisher_id) {
            this.publisher_id = publisher_id;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getResource() {
            return resource;
        }

        public void setResource(String resource) {
            this.resource = resource;
        }

        public String getSearch_keyword() {
            return search_keyword;
        }

        public void setSearch_keyword(String search_keyword) {
            this.search_keyword = search_keyword;
        }

        public int getSensitive() {
            return sensitive;
        }

        public void setSensitive(int sensitive) {
            this.sensitive = sensitive;
        }

        public String getSinger() {
            return singer;
        }

        public void setSinger(String singer) {
            this.singer = singer;
        }

        public String getSrt_file_url() {
            return srt_file_url;
        }

        public void setSrt_file_url(String srt_file_url) {
            this.srt_file_url = srt_file_url;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
    }

    public static class VideoBean {
        /**
         * age_type : 1
         * album_id : 148
         * copyright_contract_end_date : 2020-04-19
         * copyright_contract_id : 70
         * copyright_contract_start_date : 2019-04-20
         * copyright_sensitive : 0
         * created_at : 2017-04-25 17:16:07
         * detail :
         * download_type : 1
         * duration : 99.243
         * id : 11234
         * image : http://img5g22.ergedd.com/home_item/1042_1563441379313.png
         * iqiyi_fileid :
         * is_ad : 2
         * is_vip : 2
         * max_age : 8
         * min_age : 0
         * name : 我的小猪
         * play_count : 281819648
         * publisher_id : 10
         * rank : 10
         * resource : http://video5lmv.ergedd.com/videos/11234_r_480_20171122143537_5jjf.mp4
         * search_keyword :
         * sensitive : 0
         * singer :
         * srt_file_url :
         * status : 1
         * type : 1
         * updated_at : 2019-08-11 19:06:17
         */

        private int age_type;
        private int album_id;
        private String copyright_contract_end_date;
        private int copyright_contract_id;
        private String copyright_contract_start_date;
        private int copyright_sensitive;
        private String created_at;
        private String detail;
        private int download_type;
        private double duration;
        private int id;
        private String image;
        private String iqiyi_fileid;
        private int is_ad;
        private int is_vip;
        private int max_age;
        private int min_age;
        private String name;
        private int play_count;
        private int publisher_id;
        private int rank;
        private String resource;
        private String search_keyword;
        private int sensitive;
        private String singer;
        private String srt_file_url;
        private int status;
        private int type;
        private String updated_at;

        public int getAge_type() {
            return age_type;
        }

        public void setAge_type(int age_type) {
            this.age_type = age_type;
        }

        public int getAlbum_id() {
            return album_id;
        }

        public void setAlbum_id(int album_id) {
            this.album_id = album_id;
        }

        public String getCopyright_contract_end_date() {
            return copyright_contract_end_date;
        }

        public void setCopyright_contract_end_date(String copyright_contract_end_date) {
            this.copyright_contract_end_date = copyright_contract_end_date;
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

        public int getCopyright_sensitive() {
            return copyright_sensitive;
        }

        public void setCopyright_sensitive(int copyright_sensitive) {
            this.copyright_sensitive = copyright_sensitive;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
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

        public String getIqiyi_fileid() {
            return iqiyi_fileid;
        }

        public void setIqiyi_fileid(String iqiyi_fileid) {
            this.iqiyi_fileid = iqiyi_fileid;
        }

        public int getIs_ad() {
            return is_ad;
        }

        public void setIs_ad(int is_ad) {
            this.is_ad = is_ad;
        }

        public int getIs_vip() {
            return is_vip;
        }

        public void setIs_vip(int is_vip) {
            this.is_vip = is_vip;
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

        public int getPublisher_id() {
            return publisher_id;
        }

        public void setPublisher_id(int publisher_id) {
            this.publisher_id = publisher_id;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getResource() {
            return resource;
        }

        public void setResource(String resource) {
            this.resource = resource;
        }

        public String getSearch_keyword() {
            return search_keyword;
        }

        public void setSearch_keyword(String search_keyword) {
            this.search_keyword = search_keyword;
        }

        public int getSensitive() {
            return sensitive;
        }

        public void setSensitive(int sensitive) {
            this.sensitive = sensitive;
        }

        public String getSinger() {
            return singer;
        }

        public void setSinger(String singer) {
            this.singer = singer;
        }

        public String getSrt_file_url() {
            return srt_file_url;
        }

        public void setSrt_file_url(String srt_file_url) {
            this.srt_file_url = srt_file_url;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
    }
}
