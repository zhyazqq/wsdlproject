package org.example.demo;

import com.ibm.wsdl.BindingImpl;
import com.ibm.wsdl.BindingOperationImpl;
import com.ibm.wsdl.OperationImpl;
import com.sun.org.apache.xml.internal.security.utils.XPathAPI;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.*;

import javax.wsdl.*;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.ExtensionRegistry;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.wsdl.xml.WSDLWriter;
import javax.xml.namespace.QName;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.*;

public class WsdlPost {
    public static void main(String[] args) {
        postCilent();
    }

    public static void postCilent() {
//        RequestConfig config = RequestConfig.custom().setConnectTimeout(1000) // 创建连接的最长时间
//                .setConnectionRequestTimeout(500) // 从连接池中获取到连接的最长时间
//                .setSocketTimeout(3 * 1000) // 数据传输的最长时间10s
//                .build();

        String url = "http://localhost:9999/demo?wsdl";
        try {
            getOperationList(url, new ArrayList<String>());
        } catch (WSDLException e) {
            e.printStackTrace();
        }
//        HttpGet httpGget = new HttpGet();
//
//        httpGget.setConfig(config);
//
//        //创建httpcleint对象
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//
//
//        CloseableHttpResponse response = null;
//        try {
//            //采用SOAP1.1调用服务端，这种方式能调用服务端为soap1.1和soap1.2的服务
//            httpGget.setHeader("Content-Type", "text/xml;charset=UTF-8");
//
//            //采用SOAP1.2调用服务端，这种方式只能调用服务端为soap1.2的服务
//            // httpPost.setHeader("Content-Type", "application/soap+xml;charset=UTF-8");
////            StringEntity stringEntity = new StringEntity(soapBuilder.toString(), Charset.forName("UTF-8"));
////            httpPost.setEntity(stringEntity);
//            httpGget.setURI(URI.create(url));
//            response = httpClient.execute(httpGget);
//            // 判断返回状态是否为200
//            if (response.getStatusLine().getStatusCode() == 200) {
//                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
//
//                JSONObject JS = XML.toJSONObject(content);
////                System.out.println(JS);
////                System.out.println(content);
//
//            } else {
//                System.out.println("调用失败!");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (null != response) {
//                try {
//                    response.close();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//            if (null != httpClient) {
//                try {
//                    httpClient.close();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        }
    }

    public static void getOperationList(String wsdlUrl, List<String> operationList) throws WSDLException {
        // 获取wsdl定义
        WSDLFactory factory = WSDLFactory.newInstance();
        WSDLReader reader = factory.newWSDLReader();
        String factoryImplName = reader.getFactoryImplName();
        System.out.println(factoryImplName);
        Definition def = reader.readWSDL(wsdlUrl);
//        Types types = def.getTypes();
//        String namespaceURI = types.getDocumentationElement().getNamespaceURI();
//        System.out.println(namespaceURI);

        WSDLWriter wsdlWriter = factory.newWSDLWriter();
        Document document = wsdlWriter.getDocument(def);
        String baseURI = document.getDocumentElement().getSchemaTypeInfo().getTypeName();
        System.out.println(baseURI);
//        XPath xPath = XPathFactory.newInstance().newXPath();
//        xPath.setNamespaceContext(new );
//        Element documentElement = document.getDocumentElement();



//        System.out.println(bindings); style=REQUEST_RESPONSE,1
//        Map services = def.getServices();
//        System.out.println(services);
//        System.out.println(schemaTypeInfo);
//        String documentBaseURI = def.getDocumentBaseURI();
//        System.out.println(documentBaseURI);
        // 遍历bindings
//        Map messages = def.getMessages();
//        System.out.println("start----------->>>" + messages + "----------->>>end");
//        System.out.println("------------------");
//        System.out.println("start----------->>>" + messages.values() + "----------->>>end");
//        System.out.println("----------start-----------");
//        while (messages.values().iterator().hasNext()) {
//            System.out.println(messages.values().iterator().next() + "------------>>>>>>");
//        }

//        Map<String,BindingImpl> bindings = def.getBindings();
//
////        Set set = bindings.keySet();
//        Set<Map.Entry<String, BindingImpl>> entries = bindings.entrySet();
//        Iterator<Map.Entry<String, BindingImpl>> iterator = entries.iterator();
//        while (iterator.hasNext()){
//
//            BindingImpl value = iterator.next().getValue();
//            List <BindingOperationImpl>bindingOperations = value.getBindingOperations();
//            for (BindingOperationImpl bindingOperation : bindingOperations) {
//                System.out.println("----------start-----------");
////                System.out.println(bindingOperation);
//                Operation operation = bindingOperation.getOperation();
////                System.out.println(operation.getName()+"****************getName");
////                System.out.println(operation.getFaults()+"****************getFaults");
//                System.out.println("==================================");


//                System.out.println(operation.getInput()+"****************getInput");
//                System.out.println(operation.getInput().getMessage().getParts()+"****************getInput");
//                Collection values = operation.getInput().getExtensionAttributes().values();
//                values.
//                System.out.println(values);

//                System.out.println("==================================");
//                System.out.println(operation.getOutput()+"****************getOutput");
//                System.out.println(operation.getParameterOrdering()+"****************getParameterOrdering");
//                System.out.println(operation.getStyle()+"****************getStyle");
//                System.out.println("----------end-----------");
            }
//            System.out.println(bindingOperations);
//            System.out.println("----------start-----------");
//            QName qName = value.getQName();
//            System.out.println(qName);//bingding name
//            System.out.println("----------start-----------");
//        }


//        System.out.println("-------");
//            System.out.println(o);
//            System.out.println("-------");
//        }
//        System.out.println(set1);
//        System.out.println(set);
//        while (bindings.values().iterator().hasNext()) {
//            System.out.println("-----------start---------------");
//            System.out.println(bindings.values().iterator().next());
//            System.out.println("-----------end---------------");
//
//
//        }
//    }


}
