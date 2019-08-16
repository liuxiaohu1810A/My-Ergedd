package com.example.myergedd.bean;

import java.util.List;

public class ChosenBean {
        /**
         * id : 1
         * name : 儿歌
         * image : http://img5g22.ergedd.com/slide/54446175068_1493797199844.png
         * description : 中文儿歌
         * playlists : [{"id":338,"name":"手指家族","count":31,"image":"http://img5g22.ergedd.com/audio_playlist/57346360551_1547461400473.jpg","description":"动动手指学英文，经典英文童谣Finger Family","square_image_url":"http://img5g22.ergedd.com/audio_playlist/17413388600_1547461404162.jpg","erge_square_img_url":""},{"id":246,"name":"动画歌曲","count":30,"image":"http://img5g22.ergedd.com/album/120_20170414114441_l4zl.jpg","description":"动画歌曲陪伴了一代又一代人的童年，耳熟能详的经典旋律，陪伴宝宝成长。","square_image_url":"http://img5g22.ergedd.com/audio_playlist/72349241275_1493809307637.jpg","erge_square_img_url":""},{"id":198,"name":"我爱爸爸妈妈","count":29,"image":"http://img5g22.ergedd.com/audio_playlist/198_20170413112653_othd.png","description":"亲爱的爸爸妈妈辛苦了，宝宝来给你们唱首歌~","square_image_url":"http://img5g22.ergedd.com/audio_playlist/45978963753_1493809269607.jpg","erge_square_img_url":""}]
         */

        private int id;
        private String name;
        private String image;
        private String description;
        private List<PlaylistsBean> playlists;

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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<PlaylistsBean> getPlaylists() {
            return playlists;
        }

        public void setPlaylists(List<PlaylistsBean> playlists) {
            this.playlists = playlists;
        }

        public static class PlaylistsBean {
            /**
             * id : 338
             * name : 手指家族
             * count : 31
             * image : http://img5g22.ergedd.com/audio_playlist/57346360551_1547461400473.jpg
             * description : 动动手指学英文，经典英文童谣Finger Family
             * square_image_url : http://img5g22.ergedd.com/audio_playlist/17413388600_1547461404162.jpg
             * erge_square_img_url :
             */

            private int id;
            private String name;
            private int count;
            private String image;
            private String description;
            private String square_image_url;
            private String erge_square_img_url;

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

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getSquare_image_url() {
                return square_image_url;
            }

            public void setSquare_image_url(String square_image_url) {
                this.square_image_url = square_image_url;
            }

            public String getErge_square_img_url() {
                return erge_square_img_url;
            }

            public void setErge_square_img_url(String erge_square_img_url) {
                this.erge_square_img_url = erge_square_img_url;
            }
    }
}
