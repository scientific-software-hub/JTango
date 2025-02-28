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
