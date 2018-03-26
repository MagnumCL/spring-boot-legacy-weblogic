package com.magnumresearch.aqumon;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Portfolio
 * 
 * @author Jiamo Wei
 * @date 2017年12月19日
 * advice为系统和客户交互的一个抽象或者一个集合，就好像系统是一个智能理财师，给客户各种advice，客户在advice引导下做活动，
 * 例如，新给新用户一个做risktolorance的advice，用户确认以后，更新用户的的最大风险承受能力，之后引导客户建投资组合，用户输入名字以后，
 * 生成一个投资组合advice，让用户确认投资偏好（如何需要），投资金额，用户确认以后，等待执行
 * 一般一个advice只有一个confirm，如果需要多个confirm，则需要advice的组合，这样设计的目的是为了提高清晰度和灵活性
 * advice可以分为多种advice，但为了实现方便，表合并为一个表
 * advice的必要字段为：
 * id
 * type
 * status
 * confirmed_time
 * expire_time
 * 其他字段根据类型定
 * status参考common包
 */
@Entity
@Table(name = "advice")
@DynamicUpdate
public class Advice {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "portfolio_id", nullable = true)
    private Long portfolioId;

    @Column(name = "uid", nullable = true)
    private Long uid;

    @Column(name = "iaccount_id", nullable = true)
    private Long iaccountId;

	@Column(name = "type", nullable = false)
    private Integer type;

    @Column(name = "questionnaire_id", nullable = true)
    private Long questionnaireId;

    @Column(name = "record_id", nullable = true)
    private Long recordId;

    @Column(name = "reason_ref", nullable = true)
    private Long reasonRef;
    
    @Column(name = "target", nullable = true)
    private Long target;

	@Column(name = "risk_tolerance", nullable = true)
    private Integer riskTolerance;
	
	@Column(name = "risk_type", nullable = true)
    private Integer riskType;

    @Column(name = "amount", columnDefinition = "decimal(18,6)", nullable = false)
    private BigDecimal amount = BigDecimal.ZERO;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "confirm_time", nullable = true)
    private Long confirmTime;
    @Column(name = "create_time", nullable = true)
    private Long createTime;

    @Column(name = "expire_time", nullable = true)
    private Long expireTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Long questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Long confirmTime) {
        this.confirmTime = confirmTime;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public Long getReasonRef() {
        return reasonRef;
    }

    public void setReasonRef(Long reasonRef) {
        this.reasonRef = reasonRef;
    }

    public Long getTarget() {
		return target;
	}

	public void setTarget(Long target) {
		this.target = target;
	}

	public Integer getRiskTolerance() {
		return riskTolerance;
	}

	public void setRiskTolerance(Integer riskTolerance) {
		this.riskTolerance = riskTolerance;
	}
    
    public Long getIaccountId() {
		return iaccountId;
	}

	public void setIaccountId(Long iaccountId) {
		this.iaccountId = iaccountId;
	}

	public Integer getRiskType() {
		return riskType;
	}

	public void setRiskType(Integer riskType) {
		this.riskType = riskType;
	}

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
