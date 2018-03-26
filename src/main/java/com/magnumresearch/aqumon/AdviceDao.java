package com.magnumresearch.aqumon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AdviceDao extends JpaRepository<Advice, Long> {
    public Advice findById(Long id);

    public List<Advice> findByPortfolioId(Long portfolioId);

    public List<Advice> findByStatus(Integer status);

    public List<Advice> findByType(Integer type);

    public List<Advice> findByStatusAndType(Integer status, Integer type);

    public List<Advice> findByPortfolioIdAndStatus(Long portfolioId, Integer status);

    public List<Advice> findByPortfolioIdAndType(Long portfolioId, Integer type);

    public List<Advice> findByPortfolioIdAndStatusAndType(Long portfolioId, Integer status, Integer type);

    @Query(value = "update advice set status=?2 where id=?1", nativeQuery = true)
    @Modifying
    @Transactional
    public int updateStatusById(Long adviceId, Integer status);

    @Query(value = "update advice set confirm_time=?2 where id=?1", nativeQuery = true)
    @Modifying
    @Transactional
    public int updateConfirmTimeById(Long adviceId, Long confirmTime);

    public List<Advice> findByUid(Long uid);

    public List<Advice> findByUidAndType(Long uid, Integer type);

    public List<Advice> findByUidAndStatus(Long uid, Integer status);

    public List<Advice> findByUidAndStatusAndType(Long uid, Integer status, Integer type);

    public List<Advice> findByUidAndType(Integer status, Integer type);

    public List<Advice> findByUidAndStatusLessThanOrderByCreateTimeDesc(Long uid, Integer status);

    public List<Advice> findByUidAndTypeAndStatusLessThan(Long uid, Integer type, Integer status);

    public List<Advice> findByUidAndTypeAndStatusLessThanAndPortfolioId(Long uid, Integer type, Integer status, Long portfolioId);

    @Query(value = "SELECT sum(amount) FROM advice where status=?1", nativeQuery = true)
    BigDecimal getTotalMoneyByAdviceStatus(int status);

    @Query(value = "SELECT * FROM advice where  uid=?1", nativeQuery = true)
    List<Advice> getAdviceByUidAndBelowConfirmedStatus(Long uid);
}
