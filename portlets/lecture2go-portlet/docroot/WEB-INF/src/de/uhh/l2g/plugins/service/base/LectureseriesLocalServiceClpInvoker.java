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

package de.uhh.l2g.plugins.service.base;

import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Iavor Sturm
 * @generated
 */
public class LectureseriesLocalServiceClpInvoker {
	public LectureseriesLocalServiceClpInvoker() {
		_methodName0 = "addLectureseries";

		_methodParameterTypes0 = new String[] {
				"de.uhh.l2g.plugins.model.Lectureseries"
			};

		_methodName1 = "createLectureseries";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteLectureseries";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteLectureseries";

		_methodParameterTypes3 = new String[] {
				"de.uhh.l2g.plugins.model.Lectureseries"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchLectureseries";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getLectureseries";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getLectureserieses";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getLectureseriesesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateLectureseries";

		_methodParameterTypes15 = new String[] {
				"de.uhh.l2g.plugins.model.Lectureseries"
			};

		_methodName166 = "getBeanIdentifier";

		_methodParameterTypes166 = new String[] {  };

		_methodName167 = "setBeanIdentifier";

		_methodParameterTypes167 = new String[] { "java.lang.String" };

		_methodName172 = "updateLectureseries";

		_methodParameterTypes172 = new String[] {
				"de.uhh.l2g.plugins.model.Lectureseries"
			};

		_methodName173 = "getFilteredByApprovedSemesterFacultyProducer";

		_methodParameterTypes173 = new String[] {
				"java.lang.Integer", "java.lang.Long", "java.lang.Long",
				"java.lang.Long"
			};

		_methodName174 = "getFilteredByApprovedSemesterFacultyProducerAsTreeMapSortedByTerm";

		_methodParameterTypes174 = new String[] {
				"java.lang.Integer", "java.lang.Long", "java.lang.Long",
				"java.lang.Long"
			};

		_methodName175 = "getAll";

		_methodParameterTypes175 = new String[] {  };

		_methodName176 = "getAllLectureseriesWhithOpenaccessVideos";

		_methodParameterTypes176 = new String[] {  };

		_methodName177 = "getAllLectureseriesWhithPassword";

		_methodParameterTypes177 = new String[] {  };

		_methodName178 = "getAllForVideo";

		_methodParameterTypes178 = new String[] { "de.uhh.l2g.plugins.model.Video" };

		_methodName179 = "getByTerm";

		_methodParameterTypes179 = new String[] { "java.lang.Long" };

		_methodName180 = "getByLatestVideoId";

		_methodParameterTypes180 = new String[] { "java.lang.Long" };

		_methodName181 = "updateOpenAccess";

		_methodParameterTypes181 = new String[] {
				"de.uhh.l2g.plugins.model.Video",
				"de.uhh.l2g.plugins.model.Lectureseries"
			};

		_methodName182 = "updatePreviewVideoOpenAccess";

		_methodParameterTypes182 = new String[] {
				"de.uhh.l2g.plugins.model.Lectureseries"
			};

		_methodName183 = "updateUploadAndGenerationDate";

		_methodParameterTypes183 = new String[] {  };

		_methodName184 = "updateCategoryForLectureseries";

		_methodParameterTypes184 = new String[] {
				"java.lang.Long", "java.lang.Long"
			};

		_methodName185 = "getFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString";

		_methodParameterTypes185 = new String[] {
				"java.lang.Long", "java.lang.Long", "java.lang.Long",
				"java.lang.Long", "java.lang.Long", "java.lang.String"
			};

		_methodName186 = "getLatest";

		_methodParameterTypes186 = new String[] { "int" };

		_methodName187 = "getByUSID";

		_methodParameterTypes187 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return LectureseriesLocalServiceUtil.addLectureseries((de.uhh.l2g.plugins.model.Lectureseries)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return LectureseriesLocalServiceUtil.createLectureseries(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return LectureseriesLocalServiceUtil.deleteLectureseries(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return LectureseriesLocalServiceUtil.deleteLectureseries((de.uhh.l2g.plugins.model.Lectureseries)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return LectureseriesLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return LectureseriesLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return LectureseriesLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return LectureseriesLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return LectureseriesLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return LectureseriesLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return LectureseriesLocalServiceUtil.fetchLectureseries(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return LectureseriesLocalServiceUtil.getLectureseries(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return LectureseriesLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return LectureseriesLocalServiceUtil.getLectureserieses(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return LectureseriesLocalServiceUtil.getLectureseriesesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return LectureseriesLocalServiceUtil.updateLectureseries((de.uhh.l2g.plugins.model.Lectureseries)arguments[0]);
		}

		if (_methodName166.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
			return LectureseriesLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName167.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
			LectureseriesLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			return LectureseriesLocalServiceUtil.updateLectureseries((de.uhh.l2g.plugins.model.Lectureseries)arguments[0]);
		}

		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
			return LectureseriesLocalServiceUtil.getFilteredByApprovedSemesterFacultyProducer((java.lang.Integer)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3]);
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
			return LectureseriesLocalServiceUtil.getFilteredByApprovedSemesterFacultyProducerAsTreeMapSortedByTerm((java.lang.Integer)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3]);
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			return LectureseriesLocalServiceUtil.getAll();
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return LectureseriesLocalServiceUtil.getAllLectureseriesWhithOpenaccessVideos();
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			return LectureseriesLocalServiceUtil.getAllLectureseriesWhithPassword();
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return LectureseriesLocalServiceUtil.getAllForVideo((de.uhh.l2g.plugins.model.Video)arguments[0]);
		}

		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
			return LectureseriesLocalServiceUtil.getByTerm((java.lang.Long)arguments[0]);
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			return LectureseriesLocalServiceUtil.getByLatestVideoId((java.lang.Long)arguments[0]);
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			LectureseriesLocalServiceUtil.updateOpenAccess((de.uhh.l2g.plugins.model.Video)arguments[0],
				(de.uhh.l2g.plugins.model.Lectureseries)arguments[1]);

			return null;
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			LectureseriesLocalServiceUtil.updatePreviewVideoOpenAccess((de.uhh.l2g.plugins.model.Lectureseries)arguments[0]);

			return null;
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
			LectureseriesLocalServiceUtil.updateUploadAndGenerationDate();

			return null;
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			LectureseriesLocalServiceUtil.updateCategoryForLectureseries((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1]);

			return null;
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			return LectureseriesLocalServiceUtil.getFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString((java.lang.Long)arguments[0],
				(java.lang.Long)arguments[1], (java.lang.Long)arguments[2],
				(java.lang.Long)arguments[3], (java.lang.Long)arguments[4],
				(java.lang.String)arguments[5]);
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			return LectureseriesLocalServiceUtil.getLatest(((Integer)arguments[0]).intValue());
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return LectureseriesLocalServiceUtil.getByUSID((java.lang.String)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName166;
	private String[] _methodParameterTypes166;
	private String _methodName167;
	private String[] _methodParameterTypes167;
	private String _methodName172;
	private String[] _methodParameterTypes172;
	private String _methodName173;
	private String[] _methodParameterTypes173;
	private String _methodName174;
	private String[] _methodParameterTypes174;
	private String _methodName175;
	private String[] _methodParameterTypes175;
	private String _methodName176;
	private String[] _methodParameterTypes176;
	private String _methodName177;
	private String[] _methodParameterTypes177;
	private String _methodName178;
	private String[] _methodParameterTypes178;
	private String _methodName179;
	private String[] _methodParameterTypes179;
	private String _methodName180;
	private String[] _methodParameterTypes180;
	private String _methodName181;
	private String[] _methodParameterTypes181;
	private String _methodName182;
	private String[] _methodParameterTypes182;
	private String _methodName183;
	private String[] _methodParameterTypes183;
	private String _methodName184;
	private String[] _methodParameterTypes184;
	private String _methodName185;
	private String[] _methodParameterTypes185;
	private String _methodName186;
	private String[] _methodParameterTypes186;
	private String _methodName187;
	private String[] _methodParameterTypes187;
}