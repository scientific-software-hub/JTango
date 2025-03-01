[![DOI](https://zenodo.org/badge/427031484.svg)](https://doi.org/10.5281/zenodo.14949655)[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=scientific-software-hub_JTango&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=scientific-software-hub_JTango)

# JTango fork

TANGO kernel Java implementation improved and patched

# How to use

1. Add  GitHub Maven packages repo to pom.xml/settings.xml

```xml
<repositories>
    <repository>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
        <id>github-upstream</id>
        <url>https://maven.pkg.github.com/waltz-controls/*</url>
    </repository>
</repositories>
```

2. Add corresponding server to settings.xml

```xml
 <server>
    <id>github-upstream</id>
    <username>GITHUB_USER</username>
    <password>GITHUB_TOKEN</password>
</server>
```

3. Add corresponding dependcy to your pom.xml e.g. server:

```xml
<dependency>
    <groupId>org.waltz.tango</groupId>
    <artifactId>server</artifactId>
    <version>1.4.1</version>
</dependency>
```

See GitHub docs: [here](https://docs.github.com/en/packages/guides/configuring-apache-maven-for-use-with-github-packages)
