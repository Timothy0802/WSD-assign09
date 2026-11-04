FROM ubuntu:latest
LABEL authors="timothy"

ENTRYPOINT ["top", "-b"]