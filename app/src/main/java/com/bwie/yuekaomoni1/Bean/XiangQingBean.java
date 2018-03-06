package com.bwie.yuekaomoni1.Bean;

/**
 * Created by dell on 2018/3/4.
 */

public class XiangQingBean {

    /**
     * msg :
     * seller : {"description":"我是商家3","icon":"http://120.27.23.105/images/icon.png","name":"商家3","productNums":999,"score":5,"sellerid":3}
     * code : 0
     * data : {"bargainPrice":1599,"createtime":"2017-10-14T21:48:08","detailUrl":"https://item.m.jd.com/product/1993026402.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t5863/302/8961270302/97126/41feade1/5981c81cNc1b1fbef.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7003/250/1488538438/195825/53bf31ba/5981c57eN51e95176.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5665/100/8954482513/43454/418611a9/5981c57eNd5fc97ba.jpg!q70.jpg","itemtype":2,"pid":47,"price":111,"pscid":39,"salenum":757,"sellerid":3,"subhead":"碳黑色 32GB 全网通 官方标配   1件","title":"锤子 坚果Pro 特别版 巧克力色 酒红色 全网通 移动联通电信4G手机 双卡双待 碳黑色 32GB 全网通"}
     */

    private String msg;
    private SellerBean seller;
    private String code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SellerBean getSeller() {
        return seller;
    }

    public void setSeller(SellerBean seller) {
        this.seller = seller;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class SellerBean {
        /**
         * description : 我是商家3
         * icon : http://120.27.23.105/images/icon.png
         * name : 商家3
         * productNums : 999
         * score : 5
         * sellerid : 3
         */

        private String description;
        private String icon;
        private String name;
        private int productNums;
        private double score;
        private int sellerid;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getProductNums() {
            return productNums;
        }

        public void setProductNums(int productNums) {
            this.productNums = productNums;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public int getSellerid() {
            return sellerid;
        }

        public void setSellerid(int sellerid) {
            this.sellerid = sellerid;
        }
    }

    public static class DataBean {
        /**
         * bargainPrice : 1599
         * createtime : 2017-10-14T21:48:08
         * detailUrl : https://item.m.jd.com/product/1993026402.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends
         * images : https://m.360buyimg.com/n0/jfs/t5863/302/8961270302/97126/41feade1/5981c81cNc1b1fbef.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7003/250/1488538438/195825/53bf31ba/5981c57eN51e95176.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5665/100/8954482513/43454/418611a9/5981c57eNd5fc97ba.jpg!q70.jpg
         * itemtype : 2
         * pid : 47
         * price : 111
         * pscid : 39
         * salenum : 757
         * sellerid : 3
         * subhead : 碳黑色 32GB 全网通 官方标配   1件
         * title : 锤子 坚果Pro 特别版 巧克力色 酒红色 全网通 移动联通电信4G手机 双卡双待 碳黑色 32GB 全网通
         */

        private int bargainPrice;
        private String createtime;
        private String detailUrl;
        private String images;
        private int itemtype;
        private int pid;
        private double price;
        private int pscid;
        private int salenum;
        private int sellerid;
        private String subhead;
        private String title;

        public int getBargainPrice() {
            return bargainPrice;
        }

        public void setBargainPrice(int bargainPrice) {
            this.bargainPrice = bargainPrice;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getDetailUrl() {
            return detailUrl;
        }

        public void setDetailUrl(String detailUrl) {
            this.detailUrl = detailUrl;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public int getItemtype() {
            return itemtype;
        }

        public void setItemtype(int itemtype) {
            this.itemtype = itemtype;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getPscid() {
            return pscid;
        }

        public void setPscid(int pscid) {
            this.pscid = pscid;
        }

        public int getSalenum() {
            return salenum;
        }

        public void setSalenum(int salenum) {
            this.salenum = salenum;
        }

        public int getSellerid() {
            return sellerid;
        }

        public void setSellerid(int sellerid) {
            this.sellerid = sellerid;
        }

        public String getSubhead() {
            return subhead;
        }

        public void setSubhead(String subhead) {
            this.subhead = subhead;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
