package org.retest.rebazer.domain;

import java.net.URL;

import org.retest.rebazer.RepositoryHostingTypes;
import org.retest.rebazer.connector.RepositoryConnector;
import org.springframework.boot.web.client.RestTemplateBuilder;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RepositoryConfig {

	private final RepositoryHostingTypes type;
	private final URL host;
	private final String team;
	private final String repo;

	private final String user;
	private final String pass;
	private final String masterBranch;

	@Override
	public String toString() {
		return "Repo [ " + host.getHost() + "/" + team + "/" + repo + " ]";
	}

	public RepositoryConnector getConnector( final RestTemplateBuilder templateBuilder ) {
		return type.getConnector( this, templateBuilder );
	}

	public String[] getQualifiers() {
		return new String[] { host.getHost(), team, repo };
	}

	public String getUrl() {
		return host.toString() + "/" + team + "/" + repo + ".git";
	}

}
