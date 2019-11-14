package com.bank.abc.BankABCTransform.business.service.imp;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Service;

import com.bank.abc.BankABCTransform.business.service.TransformService;
import com.bank.abc.BankABCTransform.rest.model.TransformModel;
import com.bank.abc.BankABCTransform.utilities.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.schibsted.spt.data.jslt.Expression;
import com.schibsted.spt.data.jslt.Parser;

@Service("TransformService")
public class TransformServiceImp implements TransformService {
	@Override
	public String transform(TransformModel transformModel) throws JsonMappingException, JsonProcessingException, TransformerException {
		String result = null;
		switch (transformModel.getType()) {
		case "soap": {
			result = xmlToJSON(transformXSLT(transformXSLT(transformModel.getMessage(), Util.XSL_REMOVE_NAMESPACES),
					transformModel.getTemplate()));
			break;
		}
		case "rest": {
			result = transformJSLT(transformModel.getMessage(), transformModel.getTemplate());
			break;
		}
		}
		return result;
	}

	private String transformJSLT(String json, String jslt) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		String result = null;
		JsonNode input = objectMapper.readTree(json);
		Expression jsltData = Parser.compileString(jslt);
		JsonNode output = jsltData.apply(input);
		result = output.toPrettyString();
		return result;
	}

	private String xmlToJSON(String xml) {
		String result = null;
		try {
			JsonNode node = new XmlMapper().readTree(xml.getBytes());
			result = new ObjectMapper().writeValueAsString(node);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	private String transformXSLT(String origin, String xsl) throws TransformerException {
		StringWriter writer = new StringWriter();
		StringReader readerXSL = new StringReader(xsl);
		StringReader readerOrigin = new StringReader(origin);
		StreamSource xmlXSL = new StreamSource(readerXSL);
		StreamSource xmlOrigin = new StreamSource(readerOrigin);
		StreamResult xmlFinal = new StreamResult(writer);
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer(xmlXSL);
		transformer.transform(xmlOrigin, xmlFinal);
		return writer.toString();
	}
}
