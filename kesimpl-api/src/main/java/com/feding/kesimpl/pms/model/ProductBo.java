package com.feding.kesimpl.pms.model;

import com.feding.kesimpl.cms.model.PrefrenceAreaProductRelation;
import com.feding.kesimpl.cms.model.SubjectProductRelation;

import java.io.Serializable;
import java.util.List;

/**
 * 商品关联类
 */
public class ProductBo extends Product implements Serializable {
    private Long flashPromotionCount;
    private Long flashPromotionId;
    private Double flashPromotionPrice;
    private String flashPromotionSort;
    private List<MemberPrice> memeberPriceList;
    private List<PrefrenceAreaProductRelation> prefrenceAreaProductRelationList;
    private List<ProductAttributeValue> productAttributeValueList;
    private List<ProductFullReduction> productFullReductionList;
    private List<ProductLadder> productLadderList;
    private List<SkuStock> skuStockList;
    private List<SubjectProductRelation> subjectProductRelationList;

    public Long getFlashPromotionCount() {
        return flashPromotionCount;
    }

    public void setFlashPromotionCount(Long flashPromotionCount) {
        this.flashPromotionCount = flashPromotionCount;
    }

    public Long getFlashPromotionId() {
        return flashPromotionId;
    }

    public void setFlashPromotionId(Long flashPromotionId) {
        this.flashPromotionId = flashPromotionId;
    }

    public Double getFlashPromotionPrice() {
        return flashPromotionPrice;
    }

    public void setFlashPromotionPrice(Double flashPromotionPrice) {
        this.flashPromotionPrice = flashPromotionPrice;
    }

    public String getFlashPromotionSort() {
        return flashPromotionSort;
    }

    public void setFlashPromotionSort(String flashPromotionSort) {
        this.flashPromotionSort = flashPromotionSort;
    }

    public List<MemberPrice> getMemeberPriceList() {
        return memeberPriceList;
    }

    public void setMemeberPriceList(List<MemberPrice> memeberPriceList) {
        this.memeberPriceList = memeberPriceList;
    }

    public List<PrefrenceAreaProductRelation> getPrefrenceAreaProductRelationList() {
        return prefrenceAreaProductRelationList;
    }

    public void setPrefrenceAreaProductRelationList(List<PrefrenceAreaProductRelation> prefrenceAreaProductRelationList) {
        this.prefrenceAreaProductRelationList = prefrenceAreaProductRelationList;
    }

    public List<ProductAttributeValue> getProductAttributeValueList() {
        return productAttributeValueList;
    }

    public void setProductAttributeValueList(List<ProductAttributeValue> productAttributeValueList) {
        this.productAttributeValueList = productAttributeValueList;
    }

    public List<ProductFullReduction> getProductFullReductionList() {
        return productFullReductionList;
    }

    public void setProductFullReductionList(List<ProductFullReduction> productFullReductionList) {
        this.productFullReductionList = productFullReductionList;
    }

    public List<ProductLadder> getProductLadderList() {
        return productLadderList;
    }

    public void setProductLadderList(List<ProductLadder> productLadderList) {
        this.productLadderList = productLadderList;
    }

    public List<SkuStock> getSkuStockList() {
        return skuStockList;
    }

    public void setSkuStockList(List<SkuStock> skuStockList) {
        this.skuStockList = skuStockList;
    }

    public List<SubjectProductRelation> getSubjectProductRelationList() {
        return subjectProductRelationList;
    }

    public void setSubjectProductRelationList(List<SubjectProductRelation> subjectProductRelationList) {
        this.subjectProductRelationList = subjectProductRelationList;
    }
}
