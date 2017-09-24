set -ex
git config user.email "rd@cvent.com"
git config user.name "Jenkins"
echo "build script for docker compiles"
echo "Check code coverage"
mvn clean install -Pcoverage
echo "Run normal release"
mvn -Dmaven.test.failure.ignore=false \
    -Darguments="-DgitCommit=$GIT_COMMIT -DbuildId=$BUILD_ID -DgitBranch=$GIT_BRANCH" \
    --batch-mode clean release:prepare release:perform \
    -Prelease,jenkins,default \
    -DperformRelease=true
