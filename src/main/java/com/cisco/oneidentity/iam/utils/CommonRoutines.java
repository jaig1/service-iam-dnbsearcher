package com.cisco.oneidentity.iam.utils;

import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import reactor.core.publisher.Mono;

import com.cisco.oneidentity.iam.constants.OneIDConstants;
import com.cisco.oneidentity.iam.model.CRPartyDetails;
import com.cisco.oneidentity.iam.model.DNBSearchRequest;
import com.cisco.oneidentity.iam.model.GatewayRequest;
import com.cisco.oneidentity.iam.model.PartyDetails;
import com.cisco.oneidentity.iam.model.RegistrationDetails;
import com.cisco.oneidentity.iam.model.RequestBase;

public class CommonRoutines {

    public static final Logger LOGGER = LoggerFactory.getLogger(CommonRoutines.class);

    public static boolean isNullOrBlank(Object input) {
        if(input == null || "".equals(input.toString().trim()))
            return true;
        else
            return false;

    }

	public static String getToday(){
	        return new java.sql.Timestamp(System.currentTimeMillis()).toString();
	}
	
    public static GatewayRequest<Object> buildDNBSearchPayload(CRPartyDetails partyDetails){
      	 
	 	GatewayRequest<Object> gatewayRequest = new GatewayRequest<Object>();
		DNBSearchRequest dnbSearchRequest = new DNBSearchRequest();
		RegistrationDetails registrationDetails = new RegistrationDetails();
		PartyDetails ptyDetails =new PartyDetails();
		RequestBase requestBase =new RequestBase();
		requestBase.setMatchType(OneIDConstants.MATCH_TYPE);
		ptyDetails.setCountryCode(partyDetails.getCountryCode());
		ptyDetails.setDomain(partyDetails.getEmail());
		registrationDetails.setParty(ptyDetails);
		registrationDetails.setGet(requestBase);
		dnbSearchRequest.setDataArea(registrationDetails);
		dnbSearchRequest.setBodID(getUUID().toString());
		dnbSearchRequest.setComponentID(OneIDConstants.COMPONENT_ID);
		dnbSearchRequest.setReferenceID(OneIDConstants.REFERENCE_ID);
		dnbSearchRequest.setTimestamp(getToday());
		gatewayRequest.setRequest(dnbSearchRequest);
		gatewayRequest.setServiceType(OneIDConstants.DNB_SEARCH); 
	return gatewayRequest;
 }
	public static UUID getUUID() {
		UUID requestId = UUID.randomUUID();
		LOGGER.info("requestID:{}", requestId);
		return requestId;
	}
}	