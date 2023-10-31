const Eureka = require("eureka-js-client").Eureka;
const eurekaHost = "127.0.0.1";
const eurekaPort = 8761;
const hostName = "localhost";
const ipAddr = "172.0.0.1";


exports.registerWithEureka = function (appName, PORT) {
  const client = new Eureka({
    instance: {
      app: appName,
      instanceId: appName,
      hostName: hostName,
      ipAddr: ipAddr,
      port: {
        $: PORT,
        "@enabled": "true",
      },
      vipAddress: appName,
      statusPageUrl: "http://localhost:8088/info",
      healthCheckUrl: "http://localhost:8088/health",
      dataCenterInfo: {
        "@class": "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo",
        name: "MyOwn",
      },
    },
    //retry 10 time for 3 minute 20 seconds.
    eureka: {
      host: eurekaHost,
      port: eurekaPort,
      servicePath: "/eureka/apps/",
      maxRetries: 10,
      requestRetryDelay: 2000,
    },
  });

  client.logger.level("debug");

  client.start((error) => {
    console.log(error || "staff service registered");
  });

  function exitHandler(options, exitCode) {
    if (options.cleanup) {
    }
    if (exitCode || exitCode === 0) console.log(exitCode);
    if (options.exit) {
      client.stop();
    }
  }

  client.on("deregistered", () => {
    process.exit();
    console.log("after deregistered");
  });

  client.on("started", () => {
    console.log("eureka host  " + eurekaHost);
  });

  process.on("SIGINT", exitHandler.bind(null, { exit: true }));
};
