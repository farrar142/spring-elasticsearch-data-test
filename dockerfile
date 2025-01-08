# Kotlin을 실행하기 위한 기본 이미지 사용 (JDK 포함)
FROM openjdk:21-jdk-slim

# Kotlin Compiler 설치를 위한 환경 설정
ARG KOTLIN_VERSION=1.9.10

# 필요한 도구 설치 및 Kotlin Compiler 설치
RUN apt-get update && apt-get install -y --no-install-recommends \
    curl \
    unzip \
    && curl -sSLO "https://github.com/JetBrains/kotlin/releases/download/v${KOTLIN_VERSION}/kotlin-compiler-${KOTLIN_VERSION}.zip" \
    && unzip kotlin-compiler-${KOTLIN_VERSION}.zip -d /opt/kotlin \
    && ln -s /opt/kotlin/kotlinc/bin/* /usr/local/bin/ \
    && rm kotlin-compiler-${KOTLIN_VERSION}.zip \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Kotlin 실행 경로 설정
ENV PATH="/opt/kotlin/kotlinc/bin:$PATH"

# 작업 디렉토리 설정
WORKDIR /usr/src/app

# 컨테이너 실행 시 기본 명령
CMD ["tail", "-f", "/dev/null"]

# 기본 포트 설정 (필요 시)
EXPOSE 8080
