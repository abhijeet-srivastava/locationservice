docker run   -u $UID   --rm=true   -v $HOME/.ssh:/home/jenkins/.ssh:rw   -v $PWD/maven/repo:/code:rw   -w /code   docker.cvent.net/dropwizard-jenkins   /bin/bash -c "npm config set registry http://nexus.core.cvent.org:8081/nexus/content/groups/npm-public/ &&                 npm install gulp slush slush-founder &&                 node_modules/slush/bin/slush.js founder:cvt-service                   --runMode command_line                   --appName 'locationservice'                   --appDescription 'Sample Service to track location'                   --appAuthor 'A.Srivastava@cvent.com'                   --includeExample true"