package com.ljb.mvp.kotlin.resultbean.course;

import java.util.List;

public class SearchResult {

    /**
     * data : {"course_list":[{"action_num":"24万人看过","allow_download":1,"allow_play":1,"buy_stat":"36人已购买","buy_time":"1970-01-01","course_duration":"","course_id":"3ddec85a9e41336588cad51114708835","course_score":4.9,"course_weekday":6,"cover_image":"http://yxs-app.oss-cn-beijing.aliyuncs.com/bbc60ea7ab0fdad6d6717af593863e27","cover_image_1x2":"http://yxs-web.oss-cn-beijing.aliyuncs.com/upload_3f05b9b8963b235bc4f82abefd5e83c8","cover_image_2x1":"http://yxs-web.oss-cn-beijing.aliyuncs.com/upload_c33db34e7fd65cb3afbbbe55564342d9","cover_image_v2":"http://yxs-app.oss-cn-beijing.aliyuncs.com/bbc60ea7ab0fdad6d6717af593863e27","duration":"2017-12-05 21:00:00","has_bespeak":0,"has_shared":0,"is_buy":0,"is_cxy_course":0,"is_display_ask":0,"is_display_reward":0,"is_special_lesson":0,"left_top_image":"","lesson_subject":"混沌大学 年终特别课程","live_type":0,"note_article_id":"454c33c280df4373cc94762c7e0032d6","origin_type":100,"play_stat":"24万","practice_id":"","price":"","recommended_language":"","school_time":"12月05日 21:00-22:30","series_info":{},"sku_circle_image":"http://yxs-pic.oss-cn-beijing.aliyuncs.com/9737ed28d011e136c48fcd43c2e77ae8","sku_mode":"yxs","sku_name":"研习社","sku_shadow_image":"http://yxs-pic.oss-cn-beijing.aliyuncs.com/f2adf822625908f35a468091649d2083","square_image":"http://yxs-app.oss-cn-beijing.aliyuncs.com/0061c1da2a85129ed933622e447d032e","standard_school_time":"2017-12-05 21:00:00","state_control":6,"state_display":[""],"sub_title":"","tag_list":["个人成长","科学"],"teacher_head_image":"https://yxs-web.oss-cn-beijing.aliyuncs.com/633a694a7c44d9a2bb88b88014676e46.png","teacher_list":[{"teacher_head_image":"https://yxs-web.oss-cn-beijing.aliyuncs.com/633a694a7c44d9a2bb88b88014676e46.png","teacher_name":"李善友","teacher_position":"混沌大学创办人"}],"teacher_name":"李善友","teacher_position":"混沌大学创办人","time":"2017-12-05","title":"为什么聪明人也会做蠢事","type":100,"watch_times":"24万次播放","yzmall_image":"http://yxs-app.oss-cn-beijing.aliyuncs.com/0510d1ae96c7c63083afb9d5d55a308f","zxjy_info":{}}],"course_recommend_list":[]}
     * error_msg : success
     * error_no : 0
     */

    private DataBean data;
    private String error_msg;
    private int error_no;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public int getError_no() {
        return error_no;
    }

    public void setError_no(int error_no) {
        this.error_no = error_no;
    }

    public static class DataBean {
        private List<CourseListBean> course_list;
        private List<?> course_recommend_list;

        public List<CourseListBean> getCourse_list() {
            return course_list;
        }

        public void setCourse_list(List<CourseListBean> course_list) {
            this.course_list = course_list;
        }

        public List<?> getCourse_recommend_list() {
            return course_recommend_list;
        }

        public void setCourse_recommend_list(List<?> course_recommend_list) {
            this.course_recommend_list = course_recommend_list;
        }

        public static class CourseListBean {
            /**
             * action_num : 24万人看过
             * allow_download : 1
             * allow_play : 1
             * buy_stat : 36人已购买
             * buy_time : 1970-01-01
             * course_duration :
             * course_id : 3ddec85a9e41336588cad51114708835
             * course_score : 4.9
             * course_weekday : 6
             * cover_image : http://yxs-app.oss-cn-beijing.aliyuncs.com/bbc60ea7ab0fdad6d6717af593863e27
             * cover_image_1x2 : http://yxs-web.oss-cn-beijing.aliyuncs.com/upload_3f05b9b8963b235bc4f82abefd5e83c8
             * cover_image_2x1 : http://yxs-web.oss-cn-beijing.aliyuncs.com/upload_c33db34e7fd65cb3afbbbe55564342d9
             * cover_image_v2 : http://yxs-app.oss-cn-beijing.aliyuncs.com/bbc60ea7ab0fdad6d6717af593863e27
             * duration : 2017-12-05 21:00:00
             * has_bespeak : 0
             * has_shared : 0
             * is_buy : 0
             * is_cxy_course : 0
             * is_display_ask : 0
             * is_display_reward : 0
             * is_special_lesson : 0
             * left_top_image :
             * lesson_subject : 混沌大学 年终特别课程
             * live_type : 0
             * note_article_id : 454c33c280df4373cc94762c7e0032d6
             * origin_type : 100
             * play_stat : 24万
             * practice_id :
             * price :
             * recommended_language :
             * school_time : 12月05日 21:00-22:30
             * series_info : {}
             * sku_circle_image : http://yxs-pic.oss-cn-beijing.aliyuncs.com/9737ed28d011e136c48fcd43c2e77ae8
             * sku_mode : yxs
             * sku_name : 研习社
             * sku_shadow_image : http://yxs-pic.oss-cn-beijing.aliyuncs.com/f2adf822625908f35a468091649d2083
             * square_image : http://yxs-app.oss-cn-beijing.aliyuncs.com/0061c1da2a85129ed933622e447d032e
             * standard_school_time : 2017-12-05 21:00:00
             * state_control : 6
             * state_display : [""]
             * sub_title :
             * tag_list : ["个人成长","科学"]
             * teacher_head_image : https://yxs-web.oss-cn-beijing.aliyuncs.com/633a694a7c44d9a2bb88b88014676e46.png
             * teacher_list : [{"teacher_head_image":"https://yxs-web.oss-cn-beijing.aliyuncs.com/633a694a7c44d9a2bb88b88014676e46.png","teacher_name":"李善友","teacher_position":"混沌大学创办人"}]
             * teacher_name : 李善友
             * teacher_position : 混沌大学创办人
             * time : 2017-12-05
             * title : 为什么聪明人也会做蠢事
             * type : 100
             * watch_times : 24万次播放
             * yzmall_image : http://yxs-app.oss-cn-beijing.aliyuncs.com/0510d1ae96c7c63083afb9d5d55a308f
             * zxjy_info : {}
             */

            private String action_num;
            private int allow_download;
            private int allow_play;
            private String buy_stat;
            private String buy_time;
            private String course_duration;
            private String course_id;
            private double course_score;
            private int course_weekday;
            private String cover_image;
            private String cover_image_1x2;
            private String cover_image_2x1;
            private String cover_image_v2;
            private String duration;
            private int has_bespeak;
            private int has_shared;
            private int is_buy;
            private int is_cxy_course;
            private int is_display_ask;
            private int is_display_reward;
            private int is_special_lesson;
            private String left_top_image;
            private String lesson_subject;
            private int live_type;
            private String note_article_id;
            private int origin_type;
            private String play_stat;
            private String practice_id;
            private String price;
            private String recommended_language;
            private String school_time;
            private SeriesInfoBean series_info;
            private String sku_circle_image;
            private String sku_mode;
            private String sku_name;
            private String sku_shadow_image;
            private String square_image;
            private String standard_school_time;
            private int state_control;
            private String sub_title;
            private String teacher_head_image;
            private String teacher_name;
            private String teacher_position;
            private String time;
            private String title;
            private int type;
            private String watch_times;
            private String yzmall_image;
            private ZxjyInfoBean zxjy_info;
            private List<String> state_display;
            private List<String> tag_list;
            private List<TeacherListBean> teacher_list;

            public String getAction_num() {
                return action_num;
            }

            public void setAction_num(String action_num) {
                this.action_num = action_num;
            }

            public int getAllow_download() {
                return allow_download;
            }

            public void setAllow_download(int allow_download) {
                this.allow_download = allow_download;
            }

            public int getAllow_play() {
                return allow_play;
            }

            public void setAllow_play(int allow_play) {
                this.allow_play = allow_play;
            }

            public String getBuy_stat() {
                return buy_stat;
            }

            public void setBuy_stat(String buy_stat) {
                this.buy_stat = buy_stat;
            }

            public String getBuy_time() {
                return buy_time;
            }

            public void setBuy_time(String buy_time) {
                this.buy_time = buy_time;
            }

            public String getCourse_duration() {
                return course_duration;
            }

            public void setCourse_duration(String course_duration) {
                this.course_duration = course_duration;
            }

            public String getCourse_id() {
                return course_id;
            }

            public void setCourse_id(String course_id) {
                this.course_id = course_id;
            }

            public double getCourse_score() {
                return course_score;
            }

            public void setCourse_score(double course_score) {
                this.course_score = course_score;
            }

            public int getCourse_weekday() {
                return course_weekday;
            }

            public void setCourse_weekday(int course_weekday) {
                this.course_weekday = course_weekday;
            }

            public String getCover_image() {
                return cover_image;
            }

            public void setCover_image(String cover_image) {
                this.cover_image = cover_image;
            }

            public String getCover_image_1x2() {
                return cover_image_1x2;
            }

            public void setCover_image_1x2(String cover_image_1x2) {
                this.cover_image_1x2 = cover_image_1x2;
            }

            public String getCover_image_2x1() {
                return cover_image_2x1;
            }

            public void setCover_image_2x1(String cover_image_2x1) {
                this.cover_image_2x1 = cover_image_2x1;
            }

            public String getCover_image_v2() {
                return cover_image_v2;
            }

            public void setCover_image_v2(String cover_image_v2) {
                this.cover_image_v2 = cover_image_v2;
            }

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public int getHas_bespeak() {
                return has_bespeak;
            }

            public void setHas_bespeak(int has_bespeak) {
                this.has_bespeak = has_bespeak;
            }

            public int getHas_shared() {
                return has_shared;
            }

            public void setHas_shared(int has_shared) {
                this.has_shared = has_shared;
            }

            public int getIs_buy() {
                return is_buy;
            }

            public void setIs_buy(int is_buy) {
                this.is_buy = is_buy;
            }

            public int getIs_cxy_course() {
                return is_cxy_course;
            }

            public void setIs_cxy_course(int is_cxy_course) {
                this.is_cxy_course = is_cxy_course;
            }

            public int getIs_display_ask() {
                return is_display_ask;
            }

            public void setIs_display_ask(int is_display_ask) {
                this.is_display_ask = is_display_ask;
            }

            public int getIs_display_reward() {
                return is_display_reward;
            }

            public void setIs_display_reward(int is_display_reward) {
                this.is_display_reward = is_display_reward;
            }

            public int getIs_special_lesson() {
                return is_special_lesson;
            }

            public void setIs_special_lesson(int is_special_lesson) {
                this.is_special_lesson = is_special_lesson;
            }

            public String getLeft_top_image() {
                return left_top_image;
            }

            public void setLeft_top_image(String left_top_image) {
                this.left_top_image = left_top_image;
            }

            public String getLesson_subject() {
                return lesson_subject;
            }

            public void setLesson_subject(String lesson_subject) {
                this.lesson_subject = lesson_subject;
            }

            public int getLive_type() {
                return live_type;
            }

            public void setLive_type(int live_type) {
                this.live_type = live_type;
            }

            public String getNote_article_id() {
                return note_article_id;
            }

            public void setNote_article_id(String note_article_id) {
                this.note_article_id = note_article_id;
            }

            public int getOrigin_type() {
                return origin_type;
            }

            public void setOrigin_type(int origin_type) {
                this.origin_type = origin_type;
            }

            public String getPlay_stat() {
                return play_stat;
            }

            public void setPlay_stat(String play_stat) {
                this.play_stat = play_stat;
            }

            public String getPractice_id() {
                return practice_id;
            }

            public void setPractice_id(String practice_id) {
                this.practice_id = practice_id;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getRecommended_language() {
                return recommended_language;
            }

            public void setRecommended_language(String recommended_language) {
                this.recommended_language = recommended_language;
            }

            public String getSchool_time() {
                return school_time;
            }

            public void setSchool_time(String school_time) {
                this.school_time = school_time;
            }

            public SeriesInfoBean getSeries_info() {
                return series_info;
            }

            public void setSeries_info(SeriesInfoBean series_info) {
                this.series_info = series_info;
            }

            public String getSku_circle_image() {
                return sku_circle_image;
            }

            public void setSku_circle_image(String sku_circle_image) {
                this.sku_circle_image = sku_circle_image;
            }

            public String getSku_mode() {
                return sku_mode;
            }

            public void setSku_mode(String sku_mode) {
                this.sku_mode = sku_mode;
            }

            public String getSku_name() {
                return sku_name;
            }

            public void setSku_name(String sku_name) {
                this.sku_name = sku_name;
            }

            public String getSku_shadow_image() {
                return sku_shadow_image;
            }

            public void setSku_shadow_image(String sku_shadow_image) {
                this.sku_shadow_image = sku_shadow_image;
            }

            public String getSquare_image() {
                return square_image;
            }

            public void setSquare_image(String square_image) {
                this.square_image = square_image;
            }

            public String getStandard_school_time() {
                return standard_school_time;
            }

            public void setStandard_school_time(String standard_school_time) {
                this.standard_school_time = standard_school_time;
            }

            public int getState_control() {
                return state_control;
            }

            public void setState_control(int state_control) {
                this.state_control = state_control;
            }

            public String getSub_title() {
                return sub_title;
            }

            public void setSub_title(String sub_title) {
                this.sub_title = sub_title;
            }

            public String getTeacher_head_image() {
                return teacher_head_image;
            }

            public void setTeacher_head_image(String teacher_head_image) {
                this.teacher_head_image = teacher_head_image;
            }

            public String getTeacher_name() {
                return teacher_name;
            }

            public void setTeacher_name(String teacher_name) {
                this.teacher_name = teacher_name;
            }

            public String getTeacher_position() {
                return teacher_position;
            }

            public void setTeacher_position(String teacher_position) {
                this.teacher_position = teacher_position;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getWatch_times() {
                return watch_times;
            }

            public void setWatch_times(String watch_times) {
                this.watch_times = watch_times;
            }

            public String getYzmall_image() {
                return yzmall_image;
            }

            public void setYzmall_image(String yzmall_image) {
                this.yzmall_image = yzmall_image;
            }

            public ZxjyInfoBean getZxjy_info() {
                return zxjy_info;
            }

            public void setZxjy_info(ZxjyInfoBean zxjy_info) {
                this.zxjy_info = zxjy_info;
            }

            public List<String> getState_display() {
                return state_display;
            }

            public void setState_display(List<String> state_display) {
                this.state_display = state_display;
            }

            public List<String> getTag_list() {
                return tag_list;
            }

            public void setTag_list(List<String> tag_list) {
                this.tag_list = tag_list;
            }

            public List<TeacherListBean> getTeacher_list() {
                return teacher_list;
            }

            public void setTeacher_list(List<TeacherListBean> teacher_list) {
                this.teacher_list = teacher_list;
            }

            public static class SeriesInfoBean {
            }

            public static class ZxjyInfoBean {
            }

            public static class TeacherListBean {
                /**
                 * teacher_head_image : https://yxs-web.oss-cn-beijing.aliyuncs.com/633a694a7c44d9a2bb88b88014676e46.png
                 * teacher_name : 李善友
                 * teacher_position : 混沌大学创办人
                 */

                private String teacher_head_image;
                private String teacher_name;
                private String teacher_position;

                public String getTeacher_head_image() {
                    return teacher_head_image;
                }

                public void setTeacher_head_image(String teacher_head_image) {
                    this.teacher_head_image = teacher_head_image;
                }

                public String getTeacher_name() {
                    return teacher_name;
                }

                public void setTeacher_name(String teacher_name) {
                    this.teacher_name = teacher_name;
                }

                public String getTeacher_position() {
                    return teacher_position;
                }

                public void setTeacher_position(String teacher_position) {
                    this.teacher_position = teacher_position;
                }
            }
        }
    }
}
