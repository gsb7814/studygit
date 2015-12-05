package com.sxmccitlab.pcash.bo;

import com.sxmccitlab.common.PaginationSupport;
import com.sxmccitlab.pcash.po.Unit;

public interface IAccountBalanceBO {
	public abstract PaginationSupport queryMonthCheck(Unit unit, int page, int pageSize);

}
