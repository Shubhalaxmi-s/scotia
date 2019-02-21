package com.file.system.adapter.portlet;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Map;

import javax.servlet.Registration;
import javax.xml.stream.events.EntityDeclaration;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.custom.data.model.CustomData;
import com.custom.data.service.CustomDataLocalServiceUtil;
import com.data.view.model.EntityData;
import com.data.view.service.EntityDataLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.dynamic.data.mapping.io.DDMFormValuesJSONDeserializer;
import com.liferay.dynamic.data.mapping.io.DDMFormValuesJSONSerializer;
import com.liferay.dynamic.data.mapping.model.DDMStorageLink;
import com.liferay.dynamic.data.mapping.model.DDMStructureVersion;
import com.liferay.dynamic.data.mapping.service.DDMStorageLinkLocalService;
import com.liferay.dynamic.data.mapping.service.DDMStructureVersionLocalService;
import com.liferay.dynamic.data.mapping.storage.BaseStorageAdapter;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.dynamic.data.mapping.storage.StorageAdapter;
import com.liferay.expando.kernel.model.CustomAttributesDisplay;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.taglib.ui.CustomAttributeListTag;

@Component(service = StorageAdapter.class)
public class FileSystemStorageAdapter extends BaseStorageAdapter {

	@Reference
	private CounterLocalService _counterLocalService;

	@Reference
	private DDMStorageLinkLocalService _ddmStorageLinkLocalService;

	@Reference
	private DDMStructureVersionLocalService _ddmStructureVersionLocalService;
	
	@Reference
	private DDMFormValuesJSONSerializer _ddmFormValuesJSONSerializer;
	
	@Reference
	private DDMFormValuesJSONDeserializer _ddmFormValuesJSONDeserializer;
	
	@Override
	public String getStorageType() {
	    return "Custom  Table";
	}
	
	protected long doCreate(
	    long companyId, long ddmStructureId, DDMFormValues ddmFormValues, 
	    ServiceContext serviceContext)
	    throws Exception {

	    validate(ddmFormValues, serviceContext);

	    long fileId = _counterLocalService.increment();

	    DDMStructureVersion ddmStructureVersion =
	        _ddmStructureVersionLocalService.getLatestStructureVersion(
	            ddmStructureId);

	    long classNameId = PortalUtil.getClassNameId(
	        FileSystemStorageAdapter.class.getName());

	    _ddmStorageLinkLocalService.addStorageLink(
	        classNameId, fileId, ddmStructureVersion.getStructureVersionId(),
	        serviceContext);

	    saveFile(
	        ddmStructureVersion.getStructureVersionId(), fileId, ddmFormValues);

	    return fileId;
	}
	
	private File getFile(long structureId, long fileId) {
	    return new File(
	        getStructureFolder(structureId), String.valueOf(fileId));
	}

	private File getStructureFolder(long structureId) {
	    return new File(String.valueOf(structureId));
	}

	private void saveFile(
	        long structureVersionId, long fileId, DDMFormValues formValues)
	    throws IOException, JSONException {

	    String serializedDDMFormValues = _ddmFormValuesJSONSerializer.serialize(formValues);
	    

	    File formEntryFile = getFile(structureVersionId, fileId);

	    //store data in DDM FORM 
	    FileUtil.write(formEntryFile, serializedDDMFormValues);
	    
	    String JSON = new String(serializedDDMFormValues);
	    JSONObject jsondata = JSONFactoryUtil.createJSONObject(JSON);
	    
	    String objArray = jsondata.get("fieldValues").toString() ;
	        //  objArray = objArray.substring(1, objArray.length()-1);
	   
         JSONArray jsonArray = JSONFactoryUtil.createJSONArray(objArray);
	    
         // Data stored in JSON FORMAT
	    CustomData  customData = CustomDataLocalServiceUtil.createCustomData(fileId);
        customData.setData(jsonArray.toString());
        
        CustomDataLocalServiceUtil.addCustomData(customData);
        
      System.out.println("Data Stored.."); 
	    
	    
	    /*EmployeeForm empForm = EmployeeFormLocalServiceUtil.createEmployeeForm(fileId);
	    empForm.setUuid("23421312");
	    empForm.setCity("Bangalore");
	    empForm.setCountry("India");
	    empForm.setEmail("s@w.com");
	    empForm.setName("test");
	    empForm.setPhoneNumber("123456687");
	    empForm.setPincode("5600606");
	    
	    EmployeeFormLocalServiceUtil.addEmployeeForm(empForm);*/
	    		

	           /* for(int i =0 ; i < jsonArray.length() ; i++){

                     String jsonObj = jsonArray.get(i).toString();
                     JSONObject jsonObjValue = JSONFactoryUtil.createJSONObject(jsonObj);
                               String fieldName  =  jsonObjValue.get("name").toString();
                               String fieldValue =  jsonObjValue.get("value").toString();
                               
                               System.out.println("fieldName................ ===> " + fieldName);
                               System.out.println("fieldvalue..........===> " + fieldValue);
	            }*/
	  
                
	   
	}
	
	
	@Override
	protected void doDeleteByClass(long classPK) throws Exception {
	    DDMStorageLink storageLink =
	        _ddmStorageLinkLocalService.getClassStorageLink(classPK);

	    FileUtil.delete(getFile(storageLink.getStructureId(), classPK));

	    _ddmStorageLinkLocalService.deleteClassStorageLink(classPK);
	}
	
	@Override
	protected void doDeleteByDDMStructure(long ddmStructureId)
	    throws Exception {

	    FileUtil.deltree(getStructureFolder(ddmStructureId));

	    _ddmStorageLinkLocalService.deleteStructureStorageLinks(ddmStructureId);
	}
	
	@Override
	protected DDMFormValues doGetDDMFormValues(long classPK) throws Exception {
	    DDMStorageLink storageLink =
	        _ddmStorageLinkLocalService.getClassStorageLink(classPK);

	    DDMStructureVersion structureVersion =
	       /* _ddmStructureVersionLocalService.getStructureVersion(
	            storageLink.getStructureVersionId());*/
	    		_ddmStructureVersionLocalService.getStructureVersion(
	    	            storageLink.getStructureId());

	    String serializedDDMFormValues = FileUtil.read(
	        getFile(structureVersion.getStructureVersionId(), classPK));

	    return _ddmFormValuesJSONDeserializer.deserialize(
	        structureVersion.getDDMForm(), serializedDDMFormValues);
	}
	
	
	@Override
	protected void doUpdate(
	        long classPK, DDMFormValues ddmFormValues,
	        ServiceContext serviceContext)
	    throws Exception {

	    validate(ddmFormValues, serviceContext);

	    DDMStorageLink storageLink =
	        _ddmStorageLinkLocalService.getClassStorageLink(classPK);

	    saveFile(
	        storageLink.getStructureId(), storageLink.getClassPK(),
	        ddmFormValues);
	}
	
	protected void validate(
		    DDMFormValues ddmFormValues, ServiceContext serviceContext)
		    throws Exception {

		    boolean validateDDMFormValues = GetterUtil.getBoolean(
		       serviceContext.getAttribute("validateDDMFormValues"), true);

		    if (!validateDDMFormValues) {
		       return;
		    }

		  //  _ddmFormValuesValidator.validate(ddmFormValues);
		}
	
}
