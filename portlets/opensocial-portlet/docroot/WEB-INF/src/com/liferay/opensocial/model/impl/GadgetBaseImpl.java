/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.opensocial.model.impl;

import com.liferay.opensocial.model.Gadget;
import com.liferay.opensocial.service.GadgetLocalServiceUtil;

/**
 * The extended model base implementation for the Gadget service. Represents a row in the &quot;OpenSocial_Gadget&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GadgetImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GadgetImpl
 * @see com.liferay.opensocial.model.Gadget
 * @generated
 */
public abstract class GadgetBaseImpl extends GadgetModelImpl implements Gadget {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a gadget model instance should use the {@link Gadget} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			GadgetLocalServiceUtil.addGadget(this);
		}
		else {
			GadgetLocalServiceUtil.updateGadget(this);
		}
	}
}