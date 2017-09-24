set -ex

mkdir -p $HOME/.npm

docker run -u $UID \
  -v $HOME/.npm:/.npm:rw \
  -v $HOME/.ssh:/home/jenkins/.ssh:rw \
  -v $HOME/.m2:/home/jenkins/.m2:rw \
  -v $HOME/.package_cache:/home/jenkins/.package_cache \
  -v $PWD:/code:rw \
  -w /code \
  -e GIT_COMMIT=$GIT_COMMIT \
  -e BUILD_ID=$BUILD_ID \
  -e GIT_BRANCH=$GIT_BRANCH \
  -e ENVIRONMENT=$ENVIRONMENT \
  -e BUILD_NUMBER=$BUILD_NUMBER \
  --net=host \
  --rm=true \
  docker.cvent.net/dropwizard-jenkins sh $1