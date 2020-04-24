
package services;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payload {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("screen_name")
    @Expose
    private String screenName;
    @SerializedName("ads_type")
    @Expose
    private String adsType;
    @SerializedName("ad_unit_id")
    @Expose
    private String adUnitId;
    @SerializedName("ad_format")
    @Expose
    private String adFormat;
    @SerializedName("banner_width")
    @Expose
    private Integer bannerWidth;
    @SerializedName("banner_height")
    @Expose
    private Integer bannerHeight;
    @SerializedName("description")
    @Expose
    private Object description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Payload withName(String name) {
        this.name = name;
        return this;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public Payload withScreenName(String screenName) {
        this.screenName = screenName;
        return this;
    }

    public String getAdsType() {
        return adsType;
    }

    public void setAdsType(String adsType) {
        this.adsType = adsType;
    }

    public Payload withAdsType(String adsType) {
        this.adsType = adsType;
        return this;
    }

    public String getAdUnitId() {
        return adUnitId;
    }

    public void setAdUnitId(String adUnitId) {
        this.adUnitId = adUnitId;
    }

    public Payload withAdUnitId(String adUnitId) {
        this.adUnitId = adUnitId;
        return this;
    }

    public String getAdFormat() {
        return adFormat;
    }

    public void setAdFormat(String adFormat) {
        this.adFormat = adFormat;
    }

    public Payload withAdFormat(String adFormat) {
        this.adFormat = adFormat;
        return this;
    }

    public Integer getBannerWidth() {
        return bannerWidth;
    }

    public void setBannerWidth(Integer bannerWidth) {
        this.bannerWidth = bannerWidth;
    }

    public Payload withBannerWidth(Integer bannerWidth) {
        this.bannerWidth = bannerWidth;
        return this;
    }

    public Integer getBannerHeight() {
        return bannerHeight;
    }

    public void setBannerHeight(Integer bannerHeight) {
        this.bannerHeight = bannerHeight;
    }

    public Payload withBannerHeight(Integer bannerHeight) {
        this.bannerHeight = bannerHeight;
        return this;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Payload withDescription(Object description) {
        this.description = description;
        return this;
    }

}