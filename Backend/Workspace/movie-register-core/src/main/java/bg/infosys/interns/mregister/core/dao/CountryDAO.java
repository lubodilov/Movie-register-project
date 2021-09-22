package bg.infosys.interns.mregister.core.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import bg.infosys.common.db.dao.GenericDAOImpl;
import bg.infosys.interns.mregister.core.entity.Country;
import bg.infosys.interns.mregister.core.paging.CountryFilter;
import bg.infosys.interns.mregister.core.paging.PagingSorting;
import bg.infosys.interns.mregister.core.util.SortingUtil;

@Repository
public class CountryDAO extends GenericDAOImpl<Country, String> {
	
	public List<Country> findAllByFilter(CountryFilter filter, PagingSorting pagingSorting) {
		CriteriaBuilder builder = criteriaBuilder();
		CriteriaQuery<Country> criteria = builder.createQuery(Country.class);
		Root<Country> root = criteria.from(Country.class);
		
		criteria.select(root);
		
		List<Predicate> predicates = getPredicates(filter, builder, root);

		SortingUtil.<Country>sort(criteria, builder, root.get(pagingSorting.getSortBy()), pagingSorting.getSortDirection());
		criteria.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
		
		return createQuery(criteria).setFirstResult(pagingSorting.getPageSize() * pagingSorting.getPageNumber())
									.setMaxResults(pagingSorting.getPageSize())
									.getResultList();
	}

	public long countAllByFilter(CountryFilter filter) {
		CriteriaBuilder builder = criteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Country> root = criteria.from(Country.class);
		
		criteria.select(builder.countDistinct(root));
		
		List<Predicate> predicates = getPredicates(filter, builder, root);
		
		criteria.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
		
		return createQuery(criteria).getSingleResult();
	}
	
	private List<Predicate> getPredicates(CountryFilter filter, CriteriaBuilder builder, Root<Country> root){
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if (filter.getCode() != null) {			
			predicates.add(builder.equal(builder.lower(root.get(Country._code)), "%" + filter.getCode().toLowerCase() + "%"));
		}
		
		if (filter.getName() != null) {			
			predicates.add(builder.like(builder.lower(root.get(Country._name)), "%" + filter.getName().toLowerCase() + "%"));
		}
	
		//predicates.add(builder.isTrue(root.get(Country._active)));
		return predicates;
	}

}
