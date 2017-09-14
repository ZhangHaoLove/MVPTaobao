package com.example.mr_zhang.projecrttaobao.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mr_Zhang on 2017/9/14.
 */

public class ListBean {

    /**
     * count : 100
     * goodsIds : 103430,103439,103438,103442,102437,103460,102439,103444,103445,103440,
     * goodsList : [{"background":"#25ACBD","goodsId":103430,"iconText":"新品","image":"http://img31.mtime.cn/mg/2016/08/09/182222.25398042.jpg","longName":"小巧便携 懒人必备 炫酷神兽 角度随心","marketPrice":7800,"minSalePrice":5500,"name":"盗墓笔记神兽手机支架","url":"https://mall-wv.mtime.cn/#!/commerce/item/103430/"},{"background":"#25ACBD","goodsId":103439,"iconText":"新品","image":"http://img31.mtime.cn/mg/2016/08/09/183647.79225990.jpg","longName":"环保材质 轻巧便携 炫酷时尚 绿色出行","marketPrice":26800,"minSalePrice":18800,"name":"盗墓笔记环保时尚手袋","url":"https://mall-wv.mtime.cn/#!/commerce/item/103439/"},{"background":"#25ACBD","goodsId":103438,"iconText":"新品","image":"http://img31.mtime.cn/mg/2016/08/09/183835.77156164.jpg","longName":"创意刮画 新意十足 生死同行 探险不停","marketPrice":16800,"minSalePrice":11800,"name":"生死同行之创意刮画","url":"https://mall-wv.mtime.cn/#!/commerce/item/103438/"},{"background":"#25ACBD","goodsId":103442,"iconText":"新品","image":"http://img31.mtime.cn/mg/2016/08/17/150021.99968276.jpg","longName":"纱布材质 卡通印花 柔软亲肤 呵护肌肤","marketPrice":23800,"minSalePrice":10890,"name":"轻松小熊甜点纱布纯棉浴巾","url":"https://mall-wv.mtime.cn/#!/commerce/item/103442/"},{"background":"#25ACBD","goodsId":102437,"iconText":"新品","image":"http://img31.mtime.cn/mg/2016/03/08/172510.60762039.jpg","longName":"高19cm 细致工艺  专用底座","marketPrice":57100,"minSalePrice":57100,"name":"GSC 晓美焰 剧场版手办","url":"https://mall-wv.mtime.cn/#!/commerce/item/102437/"},{"background":"#25ACBD","goodsId":103460,"iconText":"新品","image":"http://img31.mtime.cn/mg/2016/08/19/172836.38532321.jpg","longName":"蜡像级人物头雕 可动素体 还原经典造型","marketPrice":198000,"minSalePrice":198000,"name":"现货-NBA哈达威蜡像级人偶","url":"https://mall-wv.mtime.cn/#!/commerce/item/103460/"},{"background":"#25ACBD","goodsId":102439,"iconText":"新品","image":"http://img31.mtime.cn/mg/2016/03/10/170923.93571679.jpg","longName":"细致工艺 丰富色彩","marketPrice":84600,"minSalePrice":84600,"name":"GSC 初音未来 花色衣","url":"https://mall-wv.mtime.cn/#!/commerce/item/102439/"},{"background":"#25ACBD","goodsId":103444,"iconText":"新品","image":"http://img31.mtime.cn/mg/2016/08/17/151556.52514811.jpg","longName":"纱布材质 卡通印花 柔软亲肤 呵护肌肤","marketPrice":4800,"minSalePrice":2190,"name":"轻松小熊甜点纱布纯棉方巾","url":"https://mall-wv.mtime.cn/#!/commerce/item/103444/"},{"background":"#25ACBD","goodsId":103445,"iconText":"新品","image":"http://img31.mtime.cn/mg/2016/08/17/152001.72146921.jpg","longName":"优选材质 卡通印花 柔软亲肤 呵护肌肤","marketPrice":16800,"minSalePrice":5990,"name":"赛车总动员儿童浴巾","url":"https://mall-wv.mtime.cn/#!/commerce/item/103445/"},{"background":"#25ACBD","goodsId":103440,"iconText":"新品","image":"http://img31.mtime.cn/mg/2016/08/09/182448.43309314.jpg","longName":"随身便携 耐磨耐用 炫酷神兽 彰显个性","marketPrice":35000,"minSalePrice":24500,"name":"盗墓笔记蓝牙音乐智能水杯","url":"https://mall-wv.mtime.cn/#!/commerce/item/103440/"}]
     * pageCount : 10
     */

    private int count;
    private String goodsIds;
    private int pageCount;
    private List<GoodsListBean> goodsList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getGoodsIds() {
        return goodsIds;
    }

    public void setGoodsIds(String goodsIds) {
        this.goodsIds = goodsIds;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<GoodsListBean> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsListBean> goodsList) {
        this.goodsList = goodsList;
    }

    public static class GoodsListBean implements Serializable{
        /**
         * background : #25ACBD
         * goodsId : 103430
         * iconText : 新品
         * image : http://img31.mtime.cn/mg/2016/08/09/182222.25398042.jpg
         * longName : 小巧便携 懒人必备 炫酷神兽 角度随心
         * marketPrice : 7800
         * minSalePrice : 5500
         * name : 盗墓笔记神兽手机支架
         * url : https://mall-wv.mtime.cn/#!/commerce/item/103430/
         */
        private int count;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        private Boolean ch_chouse;
        private String background;
        private int goodsId;
        private String iconText;
        private String image;
        private String longName;
        private int marketPrice;
        private int minSalePrice;
        private String name;
        private String url;

        public Boolean getCh_chouse() {
            return ch_chouse;
        }

        public void setCh_chouse(Boolean ch_chouse) {
            this.ch_chouse = ch_chouse;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public String getIconText() {
            return iconText;
        }

        public void setIconText(String iconText) {
            this.iconText = iconText;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getLongName() {
            return longName;
        }

        public void setLongName(String longName) {
            this.longName = longName;
        }

        public int getMarketPrice() {
            return marketPrice;
        }

        public void setMarketPrice(int marketPrice) {
            this.marketPrice = marketPrice;
        }

        public int getMinSalePrice() {
            return minSalePrice;
        }

        public void setMinSalePrice(int minSalePrice) {
            this.minSalePrice = minSalePrice;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
