# README #

### What is this repository for? ###

To reproduce an issue with local jar dependency could not be resolved when building a child module on Ubuntu machine.

### How do I get set up? ###

Build the project in order to install the common-dep dependency in local maven repository using:
clean install
Then if we try to execute a build against the child-module like: package or test ...

we will get an error:

[ERROR] Failed to execute goal on project cassandra-test: Could not resolve dependencies for project com.demo:child-module:jar:1.0-SNAPSHOT: Failed to collect dependencies for
[... Failed to read artifact descriptor for com.demo:common-dep:jar:1.0-SNAPSHOT:Could not find artifact com.demo:ubuntu-local-dependency-issue-demo-project:pom:1.0-SNAPSHOT -> [Help 1]

### STATUS ###

Resolved.

 Cause: this issue was occurring when no install command was executed against the root (parent) project,
 so the ubuntu-local-dependency-issue-demo-project was not installed in local repository this was causing the issue
 (Could not find artifact com.demo:ubuntu-local-dependency-issue-demo-project:pom:1.0-SNAPSHOT)