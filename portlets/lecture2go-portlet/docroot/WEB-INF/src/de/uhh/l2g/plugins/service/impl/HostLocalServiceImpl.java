/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package de.uhh.l2g.plugins.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import de.uhh.l2g.plugins.HostNameException;
import de.uhh.l2g.plugins.HostServerTemplateException;
import de.uhh.l2g.plugins.HostStreamerException;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.service.base.HostLocalServiceBaseImpl;

/**
 * The implementation of the host local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.HostLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.HostLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.HostLocalServiceUtil
 */
public class HostLocalServiceImpl extends HostLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.HostLocalServiceUtil} to access the host local service.
	 */
	
	public List<Host> getHosts (long groupId) throws SystemException {
	    return hostPersistence.findByGroupId(groupId);
	}
	
	public List<Host> getHosts (long groupId, int start, int end)
			   throws SystemException {
			    return hostPersistence.findByGroupId(groupId, start, end);
	}


	public List<Host> getByInstitution(long institutionId) throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Host getByHostId(long hostId) throws PortalException,
			SystemException {
		return (Host) hostPersistence.findByHostId(hostId);
	}
	
	protected void validate (String name, String streamer, String serverTemplate) throws PortalException {
	    
		if (Validator.isNull(name)) {
	       throw new HostNameException();
		 }
		
	     if (Validator.isNull(streamer) || !Validator.isDomain(streamer) ) {
	       throw new HostStreamerException();
	     }     
	     
	     if (Validator.isNull(serverTemplate)) {
	       throw new HostServerTemplateException();
	     }
	}
	
	public Host addHost(long userId, String name, String streamer, String serverTemplate,
			String protocol, String serverRoot, int port,
			ServiceContext serviceContext) throws SystemException, PortalException {
		
		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(name,streamer,serverTemplate);
		

		long hostId = counterLocalService.increment();

		Host host = hostPersistence.create(hostId);
		
		host.setUuid(serviceContext.getUuid());
		host.setUserId(userId);
		host.setGroupId(groupId);
		host.setCompanyId(user.getCompanyId());
		host.setUserName(user.getFullName());
		host.setCreateDate(serviceContext.getCreateDate(now));
		host.setModifiedDate(serviceContext.getModifiedDate(now));
		host.setName(name);
		host.setServerTemplate(serverTemplate);
		host.setStreamer(streamer);
		host.setProtocol(protocol);
		host.setServerRoot(serverRoot);
		host.setPort(port);
		host.setExpandoBridgeAttributes(serviceContext);

		hostPersistence.update(host);

		return host;
	}
	
}