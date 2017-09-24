set -ex
echo "Run integration tests for $ENVIRONMENT"
export MAVEN_OPTS=-Xmx1024m
mvn -U -P run-it -Dmaven.test.failure.ignore=false -Denv.IT_ENVIRONMENT=$ENVIRONMENT verify
