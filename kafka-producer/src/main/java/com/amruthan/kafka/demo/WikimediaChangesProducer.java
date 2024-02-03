package com.amruthan.kafka.demo;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import com.launchdarkly.eventsource.EventSource.Builder;

@Service
public class WikimediaChangesProducer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesProducer.class);
	
	private KafkaTemplate<String, String > kafkaTemplate;

	public WikimediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage() throws InterruptedException
	{
		String topic = "wikimedia_recentChange";
		
		BackgroundEventHandler bEventHandler = new WikimediaChangesHandler(kafkaTemplate, topic);
		
		String url = "https://stream.wikimedia.org/v2/stream/recentchange";
				
		BackgroundEventSource.Builder builder = new BackgroundEventSource.Builder(bEventHandler, new EventSource.Builder(URI.create(url)));
	    BackgroundEventSource bESource = builder.build();
	    bESource.start();
	    TimeUnit.MINUTES.sleep(10);
		
	}
	
	

}
