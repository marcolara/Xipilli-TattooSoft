package com.tattoosoft.business.form;

import javax.validation.constraints.NotNull;

abstract class AbstractCSRFSecurityForm {
	@NotNull
	private String _csrf;

	public String get_csrf() {
		return _csrf;
	}

	public void set_csrf(String _csrf) {
		this._csrf = _csrf;
	}
}
