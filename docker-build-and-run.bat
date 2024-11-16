call mvn clean install

call docker rm -f ms-file-rename

call docker image rm darren/ms-file-rename

call docker build . -t darren/ms-file-rename

call docker run -d --name ms-file-rename -p 8095:8080 darren/ms-file-rename
