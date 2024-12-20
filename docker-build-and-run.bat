call mvn clean install

call docker rm -f ms-file-maintenance

call docker image rm darren/ms-file-maintenance

call docker build . -t darren/ms-file-maintenance

call docker run -d --name ms-file-maintenance -p 8095:8080 darren/ms-file-maintenance
