package com.top.sstore.utils;

import com.top.sstore.dao.IndexMapper;
import com.top.sstore.dao.ServiceLabelMapper;
import com.top.sstore.dao.ServiceMapper;
import com.top.sstore.pojo.Index;
import com.top.sstore.pojo.Service;
import com.top.sstore.pojo.ServiceExample;
import com.top.sstore.pojo.ServiceLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletContext;
import java.security.Provider;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 定时器任务类:主要是继承 TimerTask并实现它的run 方法 
 */
public class AutoReceiptJob extends TimerTask {

	private static boolean isRunning = false;

	private ServletContext context = null;

	public AutoReceiptJob() {
		super();

	}

	public AutoReceiptJob(ServletContext context) {
		this.context = context;
	}

	int count = 1;



	@Override
	public void run() {
		if (!isRunning) {
			context.log("开始执行指定任务");

			/**
			 * 自己的业务代码
			 */
			/**/

			/**/
			ServiceMapper serviceMapper=(ServiceMapper)SpringUtil.getBean("serviceMapper");;
			IndexMapper indexMapper=(IndexMapper)SpringUtil.getBean("indexMapper");;
			List<Service> services = serviceMapper.selectByExample(new ServiceExample());
			System.out.println("----------------");
			Map<Integer, String> labels = services.stream().collect(Collectors.toMap(Service::getServId, Service::getLabelId));
			Set<Integer> serviceIds = labels.keySet();
//			Map<Integer, Integer> indexes = new HashMap<>();
			for (Integer serviceId : serviceIds){
				String[] labelIds = labels.get(serviceId).split(",");	//分解标签
				List<Integer> labelIdss = Arrays.stream(labelIds).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());//String[]转List<Integer>

				for (Integer labelId : labelIdss){	//遍历此商品的所有标签，并写入index
					Index index = new Index();
					index.setLabelId(labelId);
					index.setServId(serviceId);
					int a = indexMapper.insertSelective(index);
					if (a == 1)
						continue;
					else
						throw new RuntimeException();
				}
			}

			System.out.println("定时器运行了" + count + "次");
			count++;

			isRunning = false;
			context.log("指定任务执行结束");
		} else {
			context.log("上一次任务执行还未结束");
		}
	}

}
