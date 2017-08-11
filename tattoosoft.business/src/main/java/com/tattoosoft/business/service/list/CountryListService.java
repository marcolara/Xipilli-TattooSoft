package com.tattoosoft.business.service.list;

import org.springframework.stereotype.Service;

import com.tattoosoft.persistence.dao.CountryDAO;
import com.tattoosoft.persistence.model.Country;

@Service("countryListService")
public class CountryListService extends AbstractGenericListService<Country, CountryDAO>{

}
