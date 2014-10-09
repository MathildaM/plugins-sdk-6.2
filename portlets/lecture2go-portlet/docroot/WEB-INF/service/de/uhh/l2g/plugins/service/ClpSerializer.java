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

package de.uhh.l2g.plugins.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import de.uhh.l2g.plugins.model.CoordinatorClp;
import de.uhh.l2g.plugins.model.FacilityClp;
import de.uhh.l2g.plugins.model.Facility_HostClp;
import de.uhh.l2g.plugins.model.HostClp;
import de.uhh.l2g.plugins.model.LastvideolistClp;
import de.uhh.l2g.plugins.model.LectureseriesClp;
import de.uhh.l2g.plugins.model.Lectureseries_FacilityClp;
import de.uhh.l2g.plugins.model.LicenseClp;
import de.uhh.l2g.plugins.model.MetadataClp;
import de.uhh.l2g.plugins.model.OfficeClp;
import de.uhh.l2g.plugins.model.ProducerClp;
import de.uhh.l2g.plugins.model.Producer_LectureseriesClp;
import de.uhh.l2g.plugins.model.SegmentClp;
import de.uhh.l2g.plugins.model.Segment_User_VideoClp;
import de.uhh.l2g.plugins.model.SysClp;
import de.uhh.l2g.plugins.model.UploadClp;
import de.uhh.l2g.plugins.model.VideoClp;
import de.uhh.l2g.plugins.model.Video_FacilityClp;
import de.uhh.l2g.plugins.model.Video_LectureseriesClp;
import de.uhh.l2g.plugins.model.VideohitlistClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Iavor Sturm
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"lecture2go-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"lecture2go-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "lecture2go-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CoordinatorClp.class.getName())) {
			return translateInputCoordinator(oldModel);
		}

		if (oldModelClassName.equals(FacilityClp.class.getName())) {
			return translateInputFacility(oldModel);
		}

		if (oldModelClassName.equals(Facility_HostClp.class.getName())) {
			return translateInputFacility_Host(oldModel);
		}

		if (oldModelClassName.equals(HostClp.class.getName())) {
			return translateInputHost(oldModel);
		}

		if (oldModelClassName.equals(LastvideolistClp.class.getName())) {
			return translateInputLastvideolist(oldModel);
		}

		if (oldModelClassName.equals(LectureseriesClp.class.getName())) {
			return translateInputLectureseries(oldModel);
		}

		if (oldModelClassName.equals(Lectureseries_FacilityClp.class.getName())) {
			return translateInputLectureseries_Facility(oldModel);
		}

		if (oldModelClassName.equals(LicenseClp.class.getName())) {
			return translateInputLicense(oldModel);
		}

		if (oldModelClassName.equals(MetadataClp.class.getName())) {
			return translateInputMetadata(oldModel);
		}

		if (oldModelClassName.equals(OfficeClp.class.getName())) {
			return translateInputOffice(oldModel);
		}

		if (oldModelClassName.equals(ProducerClp.class.getName())) {
			return translateInputProducer(oldModel);
		}

		if (oldModelClassName.equals(Producer_LectureseriesClp.class.getName())) {
			return translateInputProducer_Lectureseries(oldModel);
		}

		if (oldModelClassName.equals(SegmentClp.class.getName())) {
			return translateInputSegment(oldModel);
		}

		if (oldModelClassName.equals(Segment_User_VideoClp.class.getName())) {
			return translateInputSegment_User_Video(oldModel);
		}

		if (oldModelClassName.equals(SysClp.class.getName())) {
			return translateInputSys(oldModel);
		}

		if (oldModelClassName.equals(UploadClp.class.getName())) {
			return translateInputUpload(oldModel);
		}

		if (oldModelClassName.equals(VideoClp.class.getName())) {
			return translateInputVideo(oldModel);
		}

		if (oldModelClassName.equals(Video_FacilityClp.class.getName())) {
			return translateInputVideo_Facility(oldModel);
		}

		if (oldModelClassName.equals(Video_LectureseriesClp.class.getName())) {
			return translateInputVideo_Lectureseries(oldModel);
		}

		if (oldModelClassName.equals(VideohitlistClp.class.getName())) {
			return translateInputVideohitlist(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputCoordinator(BaseModel<?> oldModel) {
		CoordinatorClp oldClpModel = (CoordinatorClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCoordinatorRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFacility(BaseModel<?> oldModel) {
		FacilityClp oldClpModel = (FacilityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFacilityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFacility_Host(BaseModel<?> oldModel) {
		Facility_HostClp oldClpModel = (Facility_HostClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFacility_HostRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputHost(BaseModel<?> oldModel) {
		HostClp oldClpModel = (HostClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getHostRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLastvideolist(BaseModel<?> oldModel) {
		LastvideolistClp oldClpModel = (LastvideolistClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLastvideolistRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLectureseries(BaseModel<?> oldModel) {
		LectureseriesClp oldClpModel = (LectureseriesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLectureseriesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLectureseries_Facility(
		BaseModel<?> oldModel) {
		Lectureseries_FacilityClp oldClpModel = (Lectureseries_FacilityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLectureseries_FacilityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLicense(BaseModel<?> oldModel) {
		LicenseClp oldClpModel = (LicenseClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLicenseRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMetadata(BaseModel<?> oldModel) {
		MetadataClp oldClpModel = (MetadataClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMetadataRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOffice(BaseModel<?> oldModel) {
		OfficeClp oldClpModel = (OfficeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOfficeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProducer(BaseModel<?> oldModel) {
		ProducerClp oldClpModel = (ProducerClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProducerRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProducer_Lectureseries(
		BaseModel<?> oldModel) {
		Producer_LectureseriesClp oldClpModel = (Producer_LectureseriesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProducer_LectureseriesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSegment(BaseModel<?> oldModel) {
		SegmentClp oldClpModel = (SegmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSegmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSegment_User_Video(BaseModel<?> oldModel) {
		Segment_User_VideoClp oldClpModel = (Segment_User_VideoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSegment_User_VideoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSys(BaseModel<?> oldModel) {
		SysClp oldClpModel = (SysClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSysRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUpload(BaseModel<?> oldModel) {
		UploadClp oldClpModel = (UploadClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUploadRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVideo(BaseModel<?> oldModel) {
		VideoClp oldClpModel = (VideoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVideoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVideo_Facility(BaseModel<?> oldModel) {
		Video_FacilityClp oldClpModel = (Video_FacilityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVideo_FacilityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVideo_Lectureseries(
		BaseModel<?> oldModel) {
		Video_LectureseriesClp oldClpModel = (Video_LectureseriesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVideo_LectureseriesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVideohitlist(BaseModel<?> oldModel) {
		VideohitlistClp oldClpModel = (VideohitlistClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVideohitlistRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.model.impl.CoordinatorImpl")) {
			return translateOutputCoordinator(oldModel);
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.model.impl.FacilityImpl")) {
			return translateOutputFacility(oldModel);
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.model.impl.Facility_HostImpl")) {
			return translateOutputFacility_Host(oldModel);
		}

		if (oldModelClassName.equals("de.uhh.l2g.plugins.model.impl.HostImpl")) {
			return translateOutputHost(oldModel);
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.model.impl.LastvideolistImpl")) {
			return translateOutputLastvideolist(oldModel);
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.model.impl.LectureseriesImpl")) {
			return translateOutputLectureseries(oldModel);
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.model.impl.Lectureseries_FacilityImpl")) {
			return translateOutputLectureseries_Facility(oldModel);
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.model.impl.LicenseImpl")) {
			return translateOutputLicense(oldModel);
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.model.impl.MetadataImpl")) {
			return translateOutputMetadata(oldModel);
		}

		if (oldModelClassName.equals("de.uhh.l2g.plugins.model.impl.OfficeImpl")) {
			return translateOutputOffice(oldModel);
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.model.impl.ProducerImpl")) {
			return translateOutputProducer(oldModel);
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.model.impl.Producer_LectureseriesImpl")) {
			return translateOutputProducer_Lectureseries(oldModel);
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.model.impl.SegmentImpl")) {
			return translateOutputSegment(oldModel);
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.model.impl.Segment_User_VideoImpl")) {
			return translateOutputSegment_User_Video(oldModel);
		}

		if (oldModelClassName.equals("de.uhh.l2g.plugins.model.impl.SysImpl")) {
			return translateOutputSys(oldModel);
		}

		if (oldModelClassName.equals("de.uhh.l2g.plugins.model.impl.UploadImpl")) {
			return translateOutputUpload(oldModel);
		}

		if (oldModelClassName.equals("de.uhh.l2g.plugins.model.impl.VideoImpl")) {
			return translateOutputVideo(oldModel);
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.model.impl.Video_FacilityImpl")) {
			return translateOutputVideo_Facility(oldModel);
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.model.impl.Video_LectureseriesImpl")) {
			return translateOutputVideo_Lectureseries(oldModel);
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.model.impl.VideohitlistImpl")) {
			return translateOutputVideohitlist(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("de.uhh.l2g.plugins.NoSuchCoordinatorException")) {
			return new de.uhh.l2g.plugins.NoSuchCoordinatorException();
		}

		if (className.equals("de.uhh.l2g.plugins.NoSuchFacilityException")) {
			return new de.uhh.l2g.plugins.NoSuchFacilityException();
		}

		if (className.equals("de.uhh.l2g.plugins.NoSuchFacility_HostException")) {
			return new de.uhh.l2g.plugins.NoSuchFacility_HostException();
		}

		if (className.equals("de.uhh.l2g.plugins.NoSuchHostException")) {
			return new de.uhh.l2g.plugins.NoSuchHostException();
		}

		if (className.equals("de.uhh.l2g.plugins.NoSuchLastvideolistException")) {
			return new de.uhh.l2g.plugins.NoSuchLastvideolistException();
		}

		if (className.equals("de.uhh.l2g.plugins.NoSuchLectureseriesException")) {
			return new de.uhh.l2g.plugins.NoSuchLectureseriesException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException")) {
			return new de.uhh.l2g.plugins.NoSuchLectureseries_FacilityException();
		}

		if (className.equals("de.uhh.l2g.plugins.NoSuchLicenseException")) {
			return new de.uhh.l2g.plugins.NoSuchLicenseException();
		}

		if (className.equals("de.uhh.l2g.plugins.NoSuchMetadataException")) {
			return new de.uhh.l2g.plugins.NoSuchMetadataException();
		}

		if (className.equals("de.uhh.l2g.plugins.NoSuchOfficeException")) {
			return new de.uhh.l2g.plugins.NoSuchOfficeException();
		}

		if (className.equals("de.uhh.l2g.plugins.NoSuchProducerException")) {
			return new de.uhh.l2g.plugins.NoSuchProducerException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException")) {
			return new de.uhh.l2g.plugins.NoSuchProducer_LectureseriesException();
		}

		if (className.equals("de.uhh.l2g.plugins.NoSuchSegmentException")) {
			return new de.uhh.l2g.plugins.NoSuchSegmentException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.NoSuchSegment_User_VideoException")) {
			return new de.uhh.l2g.plugins.NoSuchSegment_User_VideoException();
		}

		if (className.equals("de.uhh.l2g.plugins.NoSuchSysException")) {
			return new de.uhh.l2g.plugins.NoSuchSysException();
		}

		if (className.equals("de.uhh.l2g.plugins.NoSuchUploadException")) {
			return new de.uhh.l2g.plugins.NoSuchUploadException();
		}

		if (className.equals("de.uhh.l2g.plugins.NoSuchVideoException")) {
			return new de.uhh.l2g.plugins.NoSuchVideoException();
		}

		if (className.equals("de.uhh.l2g.plugins.NoSuchVideo_FacilityException")) {
			return new de.uhh.l2g.plugins.NoSuchVideo_FacilityException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException")) {
			return new de.uhh.l2g.plugins.NoSuchVideo_LectureseriesException();
		}

		if (className.equals("de.uhh.l2g.plugins.NoSuchVideohitlistException")) {
			return new de.uhh.l2g.plugins.NoSuchVideohitlistException();
		}

		return throwable;
	}

	public static Object translateOutputCoordinator(BaseModel<?> oldModel) {
		CoordinatorClp newModel = new CoordinatorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCoordinatorRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFacility(BaseModel<?> oldModel) {
		FacilityClp newModel = new FacilityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFacilityRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFacility_Host(BaseModel<?> oldModel) {
		Facility_HostClp newModel = new Facility_HostClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFacility_HostRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputHost(BaseModel<?> oldModel) {
		HostClp newModel = new HostClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setHostRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLastvideolist(BaseModel<?> oldModel) {
		LastvideolistClp newModel = new LastvideolistClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLastvideolistRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLectureseries(BaseModel<?> oldModel) {
		LectureseriesClp newModel = new LectureseriesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLectureseriesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLectureseries_Facility(
		BaseModel<?> oldModel) {
		Lectureseries_FacilityClp newModel = new Lectureseries_FacilityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLectureseries_FacilityRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLicense(BaseModel<?> oldModel) {
		LicenseClp newModel = new LicenseClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLicenseRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMetadata(BaseModel<?> oldModel) {
		MetadataClp newModel = new MetadataClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMetadataRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOffice(BaseModel<?> oldModel) {
		OfficeClp newModel = new OfficeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOfficeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProducer(BaseModel<?> oldModel) {
		ProducerClp newModel = new ProducerClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProducerRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProducer_Lectureseries(
		BaseModel<?> oldModel) {
		Producer_LectureseriesClp newModel = new Producer_LectureseriesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProducer_LectureseriesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSegment(BaseModel<?> oldModel) {
		SegmentClp newModel = new SegmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSegmentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSegment_User_Video(
		BaseModel<?> oldModel) {
		Segment_User_VideoClp newModel = new Segment_User_VideoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSegment_User_VideoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSys(BaseModel<?> oldModel) {
		SysClp newModel = new SysClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSysRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUpload(BaseModel<?> oldModel) {
		UploadClp newModel = new UploadClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUploadRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVideo(BaseModel<?> oldModel) {
		VideoClp newModel = new VideoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVideoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVideo_Facility(BaseModel<?> oldModel) {
		Video_FacilityClp newModel = new Video_FacilityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVideo_FacilityRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVideo_Lectureseries(
		BaseModel<?> oldModel) {
		Video_LectureseriesClp newModel = new Video_LectureseriesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVideo_LectureseriesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVideohitlist(BaseModel<?> oldModel) {
		VideohitlistClp newModel = new VideohitlistClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVideohitlistRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}