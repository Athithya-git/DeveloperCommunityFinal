package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Feed;

@Repository
public interface FeedRepository extends JpaRepository<Feed, Integer> {

	@Query("from Feed f where f.feedId=?1")
	public Feed getById(int feedId);

	@Query("from Feed where topic = :topic")
	public List<Feed> findFeedByTopic(@Param("topic") String topic);

	@Query(value = "select * from Feed fd where fd.topic like %:keyword%", nativeQuery = true)
	public List<Feed> findFeedByKeyword(@Param("keyword") String keyword);

}
