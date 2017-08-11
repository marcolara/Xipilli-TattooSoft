package com.tattoosoft.business.service.list;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tattoosoft.persistence.dao.StateProvinceRegionDAO;
import com.tattoosoft.persistence.model.Country;
import com.tattoosoft.persistence.model.StateProvinceRegion;

@Service("stateProvinceRegionService")
@Transactional
public class StateProvinceRegionListService extends AbstractGenericListService<StateProvinceRegion, StateProvinceRegionDAO> {
	public List<StateProvinceRegion> getByCountry(Country country){
		DetachedCriteria query = DetachedCriteria.forClass(StateProvinceRegion.class)
				.add( Property.forName("country").eq(country) );
		return dao.findByDetachedCriteria(query);
	}
}
