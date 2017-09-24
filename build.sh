set -ex
echo "build script for docker compiles"
echo "Check code coverage"
mvn clean install -U -Pcoverage
echo "Run normal build"
mvn -Dmaven.test.failure.ignore=false \
    -DgitCommit=$GIT_COMMIT \
    -DbuildId=$BUILD_ID \
    -DgitBranch=$GIT_BRANCH \
    -U clean deploy \
    -Prelease,jenkins,default \
    -DperformRelease=true
