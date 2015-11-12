/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This file is part of Liferay Social Office. Liferay Social Office is free
 * software: you can redistribute it and/or modify it under the terms of the GNU
 * Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Liferay Social Office is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Liferay Social Office. If not, see http://www.gnu.org/licenses/agpl-3.0.html.
 */

package com.liferay.microblogs.hook.upgrade;

import com.liferay.microblogs.hook.upgrade.v1_0_2.UpgradeMicroblogsEntry;
import com.liferay.microblogs.hook.upgrade.v1_0_2.UpgradeSocial;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Matthew Kong
 */
public class UpgradeProcess_1_0_2 extends UpgradeProcess {

	@Override
	public int getThreshold() {
		return 102;
	}

	@Override
	protected void doUpgrade() throws Exception {
		upgrade(UpgradeMicroblogsEntry.class);
		upgrade(UpgradeSocial.class);
	}

}