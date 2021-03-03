package com.duo.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Bill {
    private Integer id;//
    private String  billCode;//
    private String  productName;//
    private String  productDesc;//
    private  String productUntil;//
    private BigDecimal productCount;//
    private BigDecimal totalPrice;//
    private  Integer isPayment;//
    private  Integer providerId;//
    private  Integer createBy;//
    private Date creationDate;
    private  Integer modifyBy;//
    private  Date modifyDate;//

    private  String providerName;//
}
