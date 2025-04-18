const weather_icons = {
    1: "day-sunny",
    2: "day-sunny-overcast",
    3: "day-sunny-overcast",
    4: "day-sunny-overcast",
    5: "day-sunny-overcast",
    6: "day-sunny-overcast",
    7: "day-cloudy",
    8: "cloudy",
    11: "fog",
    12: "showers",
    13: "day-showers",
    14: "day-showers",
    15: "thunderstorm",
    16: "day-storm-showers",
    17: "day-storm-showers",
    18: "rain",
    19: "snow-wind",
    20: "day-snow",
    21: "day-snow",
    22: "snow",
    23: "day-snow",
    24: "snowflake-cold",
    25: "sleet",
    26: "rain-mix",
    29: "rain-mix",
    30: "hot",
    31: "snowflake-cold",
    32: "strong-wind",
    33: "night-clear",
    34: "night-alt-cloudy",
    35: "night-alt-cloudy",
    36: "night-alt-cloudy",
    37: "night-alt-cloudy",
    38: "night-alt-cloudy",
    39: "night-showers",
    40: "night-showers",
    41: "night-alt-storm-showers",
    42: "night-alt-storm-showers",
    43: "night-alt-snow-wind",
    44: "night-alt-snow-wind",
};

const cacheWeatherCurrent = {
    icon: 0,
    text: "",
    humidity: 0,
    isDayTime: false,
    cloud: {
        coverage: 0,
        ceiling: {
            metric: {
                value: 0,
                unit: "m",
            },
            imperial: {
                value: 0,
                unit: "ft",
            },
        }
    },
    precipitation: {
        has: false,
        type: "",
        measure: {
            metric: {
                value: 0,
                unit: "mm",
            },
            imperial: {
                value: 0,
                unit: "in",
            },
        },
        summary: {
            pastHour: {
                metric: {
                    value: 0,
                    unit: "mm",
                },
                imperial: {
                    value: 0,
                    unit: "in",
                },
            },
            past3Hours: {
                metric: {
                    value: 0,
                    unit: "mm",
                },
                imperial: {
                    value: 0,
                    unit: "in",
                },
            },
            past6Hours: {
                metric: {
                    value: 0,
                    unit: "mm",
                },
                imperial: {
                    value: 0,
                    unit: "in",
                },
            },
            past12Hours: {
                metric: {
                    value: 0,
                    unit: "mm",
                },
                imperial: {
                    value: 0,
                    unit: "in",
                },
            },
            past18Hours: {
                metric: {
                    value: 0,
                    unit: "mm",
                },
                imperial: {
                    value: 0,
                    unit: "in",
                },
            },
            past24Hours: {
                metric: {
                    value: 0,
                    unit: "mm",
                },
                imperial: {
                    value: 0,
                    unit: "in",
                },
            },
        },
    },
    temperature: {
        text: "",
        measure: {
            metric: {
                value: 0,
                unit: "°C",
            },
            imperial: {
                value: 0,
                unit: "°F",
            },
        },
        feel: {
            metric: {
                value: 0,
                unit: "°C",
            },
            imperial: {
                value: 0,
                unit: "°F",
            },
        },
    },
    wind: {
        direction: {
            value: 0,
            cardinal: "",
            unit: {
                name: "Deg",
                unit: "°",
            },
        },
        speed: {
            metric: {
                value: 0,
                unit: "km/h",
            },
            imperial: {
                value: 0,
                unit: "mi/h",
            },
        },
    },
    uv: {
        index: 0,
        text: "",
    },
    visibility: {
        metric: {
            value: 0,
            unit: "km",
        },
        imperial: {
            value: 0,
            unit: "mi",
        },
    },
    pressure: {
        metric: {
            value: 0,
            unit: "mb",
        },
        imperial: {
            value: 0,
            unit: "inHg",
        },
    },
    lastRequest: 0,
}

const cacheWeatherToday = {
    sun: {
        rise: 0,
        set: 0,
        hours: 0,
    },
    moon: {
        rise: 0,
        set: 0,
        phase: 0,
        age: 0,
    },
    temperature: {
        text: {
            minimum: "",
            maximum: "",
        },
        measure: {
            minimum: {
                metric: {
                    value: 0,
                    unit: "°C",
                },
                imperial: {
                    value: 0,
                    unit: "°F",
                },
            },
            maximum: {
                metric: {
                    value: 0,
                    unit: "°C",
                },
                imperial: {
                    value: 0,
                    unit: "°F",
                },
            },
        },
        feel: {
            minimum: {
                metric: {
                    value: 0,
                    unit: "°C",
                },
                imperial: {
                    value: 0,
                    unit: "°F",
                },
            },
            maximum: {
                metric: {
                    value: 0,
                    unit: "°C",
                },
                imperial: {
                    value: 0,
                    unit: "°F",
                },
            },
        },
        summary: {
            heating: {
                metric: {
                    value: 0,
                    unit: "°C",
                },
                imperial: {
                    value: 0,
                    unit: "°F",
                },
            },
            cooling: {
                metric: {
                    value: 0,
                    unit: "°C",
                },
                imperial: {
                    value: 0,
                    unit: "°F",
                },
            }
        },
    },
    air: {
        quality: {
            category: "",
            type: "",
            value: 0,

        },
        grass: {
            category: "",
            value: 0,
        },
        mold: {
            category: "",
            value: 0,
        },
        ragweed: {
            category: "",
            value: 0,
        },
        tree: {
            category: "",
            value: 0,
        },
    },
    uv: {
        category: "",
        value: 0,
    },
    day: {
        icon: 0,
        text: {
            tiny: "",
            short: "",
            long: "",
        },
        probabilities: {
            precipitation: 0,
            thunderstorm: 0,
            rain: 0,
            snow: 0,
            ice: 0,
        },
        wind: {
            speed: {
                metric: {
                    value: 0,
                    unit: "km/h",
                },
                imperial: {
                    value: 0,
                    unit: "mi/h",
                },
            },
            direction: {
                value: 0,
                cardinal: "",
                unit: {
                    name: "Deg",
                    unit: "°",
                },
            },
        },
        amount: {
            rain: {
                metric: {
                    value: 0,
                    unit: "mm",
                },
                imperial: {
                    value: 0,
                    unit: "in",
                },
                hours: 0,
            }, 
            snow: {
                metric: {
                    value: 0,
                    unit: "mm",
                },
                imperial: {
                    value: 0,
                    unit: "in",
                },
                hours: 0,
            },
            ice: {
                metric: {
                    value: 0,
                    unit: "mm",
                },
                imperial: {
                    value: 0,
                    unit: "in",
                },
                hours: 0
            },
            total: {
                metric: {
                    value: 0,
                    unit: "mm",
                },
                imperial: {
                    value: 0,
                    unit: "in",
                },
                hours: 0,
            },
        },
        light: {
            cloudCover: 0,
            solarIrradiance: {
                value: 0,
                unit: "W/m²",
            },
            evapotranspiration: {
                metric: {
                    value: 0,
                    unit: "mm",
                },
                imperial: {
                    value: 0,
                    unit: "in"
                },
            },
        },
    },
    night: {
        icon: 0,
        text: {
            tiny: "",
            short: "",
            long: "",
        },
        probabilities: {
            precipitation: 0,
            thunderstorm: 0,
            rain: 0,
            snow: 0,
            ice: 0,
        },
        wind: {
            speed: {
                metric: {
                    value: 0,
                    unit: "km/h",
                },
                imperial: {
                    value: 0,
                    unit: "mi/h",
                },
            },
            direction: {
                value: 0,
                cardinal: "",
                unit: {
                    name: "Deg",
                    unit: "°",
                },
            }
        },
        amount: {
            rain: {
                metric: {
                    value: 0,
                    unit: "mm",
                },
                imperial: {
                    value: 0,
                    unit: "in",
                },
                hours: 0,
            }, 
            snow: {
                metric: {
                    value: 0,
                    unit: "mm",
                },
                imperial: {
                    value: 0,
                    unit: "in",
                },
                hours: 0,
            },
            ice: {
                metric: {
                    value: 0,
                    unit: "mm",
                },
                imperial: {
                    value: 0,
                    unit: "in",
                },
                hours: 0
            },
            total: {
                metric: {
                    value: 0,
                    unit: "mm",
                },
                imperial: {
                    value: 0,
                    unit: "in",
                },
                hours: 0,
            },
        },
        light: {
            cloudCover: 0,
            solarIrradiance: {
                value: 0,
                unit: "W/m²",
            },
            evapotranspiration: {
                metric: {
                    value: 0,
                    unit: "mm",
                },
                imperial: {
                    value: 0,
                    unit: "in"
                }
            },
        },
    },
}

const cacheWeatherForecast = {
    headline: {
        text: "",
        type: "",
        severity: 0,
    },
    days: new Array(cacheWeatherToday),
    lastRequest: 0,
}

function getWeatherCache(){
    let data = JSON.parse(localStorage.getItem("weather"));
    if (data){
        weather_widget.cache.city = data.city;
        weather_widget.cache.today = data.today;
        weather_widget.cache.api_key = data.api_key;
        weather_widget.cache.current = data.current;
        weather_widget.cache.forecast = data.forecast;
        weather_widget.cache.location = data.location;
    }
}

function setWeatherCache(){
    localStorage.setItem("weather", 
        JSON.stringify({
            city: weather_widget.cache.city,
            today: weather_widget.cache.today,
            api_key: weather_widget.cache.api_key,
            current: weather_widget.cache.current,
            forecast: weather_widget.cache.forecast,
            location: weather_widget.cache.location,
        }
    ));
}

async function getCityCode(){

    getWeatherCache();

    if (weather_widget.cache.location !== weather_widget.properties.location){
        const res = await fetch(
            `https://dataservice.accuweather.com/locations/v1/cities/search?apikey=${weather_widget.properties.api_key}&q=${encodeURI(weather_widget.properties.location)}&language=en-USoffset=1`, 
            {
                method: "GET",
                headers: {"Accept-Encoding": "gzip"}
            },
        );
        switch(res.status){
            case 200:
                let data = await res.json();
                if (data.length > 0){
                    weather_widget.cache.city = data[0].Key;
                    weather_widget.cache.api_key = weather_widget.properties.api_key;
                    weather_widget.cache.location = weather_widget.properties.location;
                    setWeatherCache();
                    return {success: true}
                } else {
                    alerts("Weather Error:", "Cannot find your city, search it first on AccuWeather's website.");
                    return {success: false}
                }
            case 400:
                alerts("Weather Error:", "Bad syntax while searching your city.");
                return {success: false}
            case 401:
                alerts("Weather Error:", "Your API Key might be incorrect, please review it.");
                return {success: false}
            default:
                alerts("Weather Error:", "Cannot reach AccuWeather's API.");
                return {success: false}
        }
    } else {
        return {success: true}
    }
}

async function getCurrentWeather(){
    const city = await getCityCode();
    if (city.success){
        if (Date.now() > weather_widget.cache.current.lastRequest){ // If 1 hour passed
        const res = await fetch(
                `https://dataservice.accuweather.com/currentconditions/v1/${weather_widget.cache.city}?apikey=${weather_widget.cache.api_key}&details=true`,
                {
                    method: "GET",
                    headers: {"Accept-Encoding": "gzip"}
                },
            );
            switch(res.status){
                case 200:
                    try {
                        let [data] = await res.json();
                        let current = weather_widget.cache.current;
                        // General
                        current.text = data.WeatherText;
                        current.icon = data.WeatherIcon;
                        current.isDayTime = data.IsDayTime;
                        current.humidity = data.RelativeHumidity;

                        weather_widget.cache.current.lastRequest = Date.now() + (1000 * 60 * 60);
                        // Temperature
                        current.temperature.measure.metric.value = data.Temperature.Metric.Value;
                        current.temperature.measure.imperial.value = data.Temperature.Imperial.Value;
                        current.temperature.feel.metric.value = data.RealFeelTemperature.Metric.Value;
                        current.temperature.feel.imperial.value = data.RealFeelTemperature.Imperial.Value;
                        current.temperature.text = data.RealFeelTemperature.Metric.Phrase;
                        // Wind
                        current.wind.direction.value = data.Wind.Direction.Degrees;
                        current.wind.direction.cardinal = data.Wind.Direction.English;
                        current.wind.speed.metric.value = data.Wind.Speed.Metric.Value;
                        current.wind.speed.imperial.value = data.Wind.Speed.Imperial.Value;
                        // UV
                        current.uv.index = data.UVIndex;
                        current.uv.text = data.UVIndexText;
                        // Visibility
                        current.visibility.metric = data.Visibility.Metric.Value;
                        current.visibility.imperial = data.Visibility.Imperial.Value;
                        // Cloud
                        current.cloud.coverage = data.CloudCover;
                        current.cloud.ceiling.metric.value = data.Ceiling.Metric.Value;
                        current.cloud.ceiling.imperial.value = data.Ceiling.Imperial.Value;
                        // Pressure
                        current.pressure.metric.value = data.Pressure.Metric.Value;
                        current.pressure.imperial.value = data.Pressure.Imperial.Value;
                        // Precipitation
                        current.precipitation.has = data.HasPrecipitation;
                        current.precipitation.type = data.PrecipitationType;
                        current.precipitation.measure.metric.value = data.PrecipitationSummary.Precipitation.Metric.Value;
                        current.precipitation.measure.imperial.value = data.PrecipitationSummary.Precipitation.Imperial.Value;
                        current.precipitation.summary.pastHour.metric.value = data.PrecipitationSummary.PastHour.Metric.Value;
                        current.precipitation.summary.pastHour.imperial.value = data.PrecipitationSummary.PastHour.Imperial.Value;
                        current.precipitation.summary.past3Hours.metric.value = data.PrecipitationSummary.Past3Hours.Metric.Value;
                        current.precipitation.summary.past3Hours.imperial.value = data.PrecipitationSummary.Past3Hours.Imperial.Value;
                        current.precipitation.summary.past6Hours.metric.value = data.PrecipitationSummary.Past6Hours.Metric.Value;
                        current.precipitation.summary.past6Hours.imperial.value = data.PrecipitationSummary.Past6Hours.Imperial.Value;
                        current.precipitation.summary.past12Hours.metric.value = data.PrecipitationSummary.Past12Hours.Metric.Value;
                        current.precipitation.summary.past12Hours.imperial.value = data.PrecipitationSummary.Past12Hours.Imperial.Value;
                        current.precipitation.summary.past18Hours.metric.value = data.PrecipitationSummary.Past18Hours.Metric.Value;
                        current.precipitation.summary.past18Hours.imperial.value = data.PrecipitationSummary.Past18Hours.Imperial.Value;
                        current.precipitation.summary.past24Hours.metric.value = data.PrecipitationSummary.Past24Hours.Metric.Value;
                        current.precipitation.summary.past24Hours.imperial.value = data.PrecipitationSummary.Past24Hours.Imperial.Value;
                        setWeatherCache();
                        return {success: true, data: weather_widget.cache.current, error: null, code: res.status};
                    } catch (e){
                        alerts("Weather Error:", "Cannot reach AccuWeather's API.");
                        return {sucess: false, data: null, error: "Weather is not available", code: 599};
                    }
                default:
                    alerts("Weather Error:", "Cannot reach AccuWeather's API.");
                    break;
            }
        } else {
            return {success: true, data: weather_widget.cache.current, error: null, code: 200}; 
        }
    }
};

async function getForecastWeather(){

    const metricConverter = (type, value) => {
        switch(type){
            case "in":
                return parseFloat((value*25.4).toFixed(1)); // Returns mm
            case "mi/h":
                return parseFloat((value*1.609344).toFixed(1)); // Returns km/h
            case "F":
                return parseFloat(((value-32)/1.8).toFixed(1)); // Returns C
        };
    };

    const city = await getCityCode();
    if (city.success){
            if (Date.now() > weather_widget.cache.forecast.lastRequest){
            const res = await fetch(
                ``,
                {
                    method: "GET",
                    headers: {"Accept-Encoding": "gzip"}
                },
            );
            switch(res.status){
                case 200:
                    try {
                        let data = await res.json();

                        // General
                        weather_widget.cache.forecast = {
                            ...weather_widget.cache.forecast,
                            headline: {
                                type: data.Headline.Category,
                                text: data.Headline.Text,
                                severity: data.Headline.Severity,
                            },
                            lastRequest: Date.now() + (1000 * 60 * 60 * 4),
                            days: []
                        }

                        for (let i = 0; i < data["DailyForecasts"].length; i++){

                            let day = data["DailyForecasts"][i];
                            let newDay = {
                                uv: { // UV Light
                                    category: day.AirAndPollen[5].Category,
                                    value: day.AirAndPollen[5].Value
                                },
                                moon: { // Moon Data
                                    age: day.Moon.Age,
                                    set: day.Moon.Set,
                                    rise: day.Moon.Rise,
                                    phase: day.Moon.Phase
                                },
                                sun: { // Sun Data
                                    set: day.Sun.Set,
                                    rise: day.Sun.Rise,
                                    hours: day.HoursOfSun,
                                },
                                air: { // Air information
                                    quality: { // Quality
                                        type: day.AirAndPollen[0].Type,
                                        value: day.AirAndPollen[0].Value,
                                        category: day.AirAndPollen[0].Category
                                    },
                                    grass: { // Grass
                                        value: day.AirAndPollen[1].Value,
                                        category: day.AirAndPollen[1].Category
                                    },
                                    mold: { // Mold
                                        value: day.AirAndPollen[2].Value,
                                        category: day.AirAndPollen[2].Category
                                    },
                                    ragweed: { // Ragweed
                                        value: day.AirAndPollen[3].Value,
                                        category: day.AirAndPollen[3].Category
                                    },
                                    tree: { // Tree
                                        value: day.AirAndPollen[4].Value,
                                        category: day.AirAndPollen[4].Category
                                    }
                                },
                                temperature: {
                                    text: { // Temperature Short Text
                                        minimum: day.RealFeelTemperature.Minimum.Phrase,
                                        maximum: day.RealFeelTemperature.Maximum.Phrase
                                    },
                                    feel: {
                                        minimum: {
                                            metric: {
                                                value: metricConverter("F", day.RealFeelTemperature.Minimum.Value),
                                                unit: "°C"
                                            },
                                            imperial: {
                                                value: day.RealFeelTemperature.Minimum.Value,
                                                unit: "°F"
                                            }
                                        },
                                        maximum: {
                                            metric: {
                                                value: metricConverter("F", day.RealFeelTemperature.Maximum.Value),
                                                unit: "°C"
                                            },
                                            imperial: {
                                                value: day.RealFeelTemperature.Maximum.Value,
                                                unit: "°F"
                                            }
                                        }
                                    },
                                    measure: {
                                        minimum: {
                                            metric: {
                                                value: metricConverter("F", day.Temperature.Minimum.Value),
                                                unit: "°C"
                                            },
                                            imperial: {
                                                value: day.Temperature.Minimum.Value,
                                                unit: "°F"
                                            }
                                        },
                                        maximum: {
                                            metric: {
                                                value: metricConverter("F", day.Temperature.Maximum.Value),
                                                unit: "°C"
                                            },
                                            imperial: {
                                                value: day.Temperature.Maximum.Value,
                                                unit: "°F"
                                            }
                                        }
                                    },
                                    summary: {
                                        cooling: {
                                            metric: {
                                                value: metricConverter("F", day.DegreeDaySummary.Cooling.Value),
                                                unit: "°C"
                                            },
                                            imperial: {
                                                value: day.DegreeDaySummary.Cooling.Value,
                                                unit: "°F"
                                            }
                                        },
                                        heating: {
                                            metric: {
                                                value: metricConverter("F", day.DegreeDaySummary.Heating.Value),
                                                unit: "°C"
                                            },
                                            imperial: {
                                                value: day.DegreeDaySummary.Heating.Value,
                                                unit: "°F"
                                            }
                                        }
                                    }
                                },
                                day: { // Day cycle Information
                                    icon: day.Day.Icon, // Icon of the Day
                                    text: {
                                        tiny: day.Day.IconPhrase, // Text summary of daylight, tiny
                                        short: day.Day.ShortPhrase, // Text summary of daylight, short
                                        long: day.Day.LongPhrase, // Text summary of daylight, long
                                    },
                                    probabilities: { // Probability of different conditions in % (Up to 100%)
                                        ice: day.Day.IceProbability,
                                        rain: day.Day.RainProbability,
                                        snow: day.Day.SnowProbability,
                                        thunderstorm: day.Day.ThunderstormProbability,
                                        precipitation: day.Day.PrecipitacionProbability
                                    },
                                    amount: {
                                        rain: { // Rain
                                            hours: day.Day.HoursOfRain,
                                            metric: {
                                                value: metricConverter("in", day.Day.Rain.Value),
                                                unit: "mm"
                                            },
                                            imperial: {
                                                value: day.Day.Rain.Value,
                                                unit: "in"
                                            }
                                        },
                                        ice: { // Ice
                                            hours: day.Day.HoursOfIce,
                                            metric: {
                                                value: metricConverter("in", day.Day.Ice.Value),
                                                unit: "mm"
                                            },
                                            imperial: {
                                                value: day.Day.Ice.Value,
                                                unit: "in"
                                            }
                                        },
                                        snow: { // Snow
                                            hours: day.Day.HoursOfSnow,
                                            metric: {
                                                value: metricConverter("in", day.Day.Snow.Value),
                                                unit: "mm"
                                            },
                                            imperial: {
                                                value: day.Day.Snow.Value,
                                                unit: "in"
                                            }
                                        },
                                        total: { // TotalPrecipitation
                                            hours: day.Day.HoursOfPrecipitation,
                                            metric: {
                                                value: metricConverter("in", day.Day.TotalLiquidValue),
                                                unit: "mm"
                                            },
                                            imperial: {
                                                value: day.Day.TotalLiquid.Value,
                                                unit: "in"
                                            }
                                        },
                                    },
                                    light: { // Light measures
                                        cloudCover: day.Day.CloudCover, // Cloud coverage in % (Up to 100%)
                                        solarIrradiance: {
                                            value: day.Day.SolarIrradiance.Value,
                                            unit: "W/m²"
                                        },
                                        evapotranspiration: {
                                            metric: {
                                                value: metricConverter("in",day.Day.Evapotranspiration.Value),
                                                unit: "mm"
                                            },
                                            imperial: {
                                                value: day.Day.Evapotranspiration.Value,
                                                unit: "in"
                                            },

                                        }
                                    },
                                    wind: { // Wind
                                        direction: {
                                            value: day.Day.Wind.Direction.Degrees,
                                            cardinal: day.Day.Wind.Direction.English,
                                            unit: {
                                                name: "Deg",
                                                unit: "°",
                                            },
                                        },
                                        speed: {
                                            metric: {
                                                value: metricConverter("mi/h", day.Day.Wind.Speed.Value),
                                                unit: "km/h"
                                            },
                                            imperial: {
                                                value: day.Day.Wind.Speed.Value,
                                                unit: "mi/h"
                                            }
                                        }
                                    }
                                },
                                night: { // Day cycle Information
                                    icon: day.Night.Icon, // Icon of the Day
                                    text: {
                                        tiny: day.Night.IconPhrase, // Text summary of daylight, tiny
                                        short: day.Night.ShortPhrase, // Text summary of daylight, short
                                        long: day.Night.LongPhrase, // Text summary of daylight, long
                                    },
                                    probabilities: { // Probability of different conditions in % (Up to 100%)
                                        ice: day.Night.IceProbability,
                                        rain: day.Night.RainProbability,
                                        snow: day.Night.SnowProbability,
                                        thunderstorm: day.Night.ThunderstormProbability,
                                        precipitation: day.Night.PrecipitacionProbability
                                    },
                                    amount: {
                                        rain: { // Rain
                                            hours: day.Night.HoursOfRain,
                                            metric: {
                                                value: metricConverter("in", day.Night.Rain.Value),
                                                unit: "mm"
                                            },
                                            imperial: {
                                                value: day.Night.Rain.Value,
                                                unit: "in"
                                            }
                                        },
                                        ice: { // Ice
                                            hours: day.Night.HoursOfIce,
                                            metric: {
                                                value: metricConverter("in", day.Night.Ice.Value),
                                                unit: "mm"
                                            },
                                            imperial: {
                                                value: day.Night.Ice.Value,
                                                unit: "in"
                                            }
                                        },
                                        snow: { // Snow
                                            hours: day.Night.HoursOfSnow,
                                            metric: {
                                                value: metricConverter("in", day.Night.Snow.Value),
                                                unit: "mm"
                                            },
                                            imperial: {
                                                value: day.Night.Snow.Value,
                                                unit: "in"
                                            }
                                        },
                                        total: { // TotalPrecipitation
                                            hours: day.Night.HoursOfPrecipitation,
                                            metric: {
                                                value: metricConverter("in", day.Night.TotalLiquidValue),
                                                unit: "mm"
                                            },
                                            imperial: {
                                                value: day.Night.TotalLiquid.Value,
                                                unit: "in"
                                            }
                                        },
                                    },
                                    light: { // Light measures
                                        cloudCover: day.Night.CloudCover, // Cloud coverage in % (Up to 100%)
                                        solarIrradiance: {
                                            value: day.Night.SolarIrradiance.Value,
                                            unit: "W/m²"
                                        },
                                        evapotranspiration: {
                                            metric: {
                                                value: metricConverter("in",day.Night.Evapotranspiration.Value),
                                                unit: "mm"
                                            },
                                            imperial: {
                                                value: day.Night.Evapotranspiration.Value,
                                                unit: "in"
                                            },

                                        }
                                    },
                                    wind: { // Wind
                                        direction: {
                                            value: day.Night.Wind.Direction.Degrees,
                                            cardinal: day.Night.Wind.Direction.English,
                                            unit: {
                                                name: "Deg",
                                                unit: "°",
                                            },
                                        },
                                        speed: {
                                            metric: {
                                                value: metricConverter("mi/h", day.Night.Wind.Speed.Value),
                                                unit: "km/h"
                                            },
                                            imperial: {
                                                value: day.Night.Wind.Speed.Value,
                                                unit: "mi/h"
                                            }
                                        }
                                    }
                                }
                            };

                            if (i === 0){
                                weather_widget.cache.today = newDay;
                            } else {
                                weather_widget.cache.forecast.days.push(newDay);
                            };
                            
                        };

                        setWeatherCache();

                        return {success: true, data: { today: weather_widget.cache.today, forecast: weather_widget.cache.forecast }, error: null, code: res.status};
                    } catch (e){
                        console.log(e);
                        alerts("Weather Error:", "Cannot reach AccuWeather's API.");
                        return {sucess: false, data: null, error: "Weather is not available", code: 599};
                    };
                default:
                    alerts("Weather Error:", "Cannot reach AccuWeather's API.");
                    break;
            };
        } else {
            return {success: true, data: { today: weather_widget.cache.today, forecast: weather_widget.cache.forecast }, error: null, code: 200}; 
        }
    }
}


async function drawWeatherLocationWidget(){
    document.getElementById("weatherCity").children[0].innerHTML = weather_widget.cache.location;
}

async function drawWeatherCurrentWidget(){

    const {success, data} = await getCurrentWeather();

    if (success){
        document.getElementById("weatherTitle").innerHTML = "WEATHER: ";

        let span = document.createElement("span");
        let icon = document.createElement("i");
        icon.classList.add("wi", "wi-" + weather_icons[data.icon]);
        span.appendChild(icon);
        span.id = "currentWeather";

        let current_temp = data.temperature.measure[MCCW.properties.weather.convention].value;
        let current_unit = data.temperature.measure[MCCW.properties.weather.convention].unit;
        let temperature = document.createTextNode(`${current_temp}${current_unit}`);

        span.appendChild(temperature);
        document.getElementById("weatherTitle").appendChild(span);
        document.getElementById("weatherContainer").style.maxWidth = "fit-content";
    }
};

async function drawWeatherForecastWidget(){
    const {success, data} = await getForecastWeather();

    if (success){
        document.getElementById("weather").innerHTML = "";

        for (let i = -1; i < data.forecast.days.length - 1; i++){

            let forecastDayElement = document.createElement("tr");
            let iconTextElement = document.createElement("td");

            let icon = document.createElement("i");

            if (i === -1){ // Today
                let currentTime = new Date().getTime(),
                    sunrise = new Date(data.today.sun.rise).getTime(),
                    sunset = new Date(data.today.sun.set).getTime();
                console.log(currentTime, sunrise, sunset);
                if (currentTime >= sunrise || currentTime < sunset){ // Dawn or day
                    console.log("today icon", weather_icons[data.today.day.icon])
                    icon.classList.add("wi", "wi-" + weather_icons[data.today.day.icon]);
                } else if (currentTime >= sunset) { // night
                    console.log("today icon", weather_icons[data.today.day.icon])
                    icon.classList.add("wi", "wi-" + weather_icons[data.today.night.icon]);
                }
            } else {
                icon.classList.add("wi", "wi-" + weather_icons[data.forecast.days[i].day.icon]);
            }

            iconTextElement.appendChild(icon);

            switch(i){
                case -1: // Today
                    iconTextElement.appendChild(document.createTextNode(" Today"));
                    break;
                case 0: // Tomorrow
                    iconTextElement.appendChild(document.createTextNode(" Tomorrow"));
                    break;
                default: // Day of the week that is next
                    let day = MCCW.variables.weekday[new Date(data.forecast.days[i].sun.rise).getDay()].toLowerCase();
                    day = day.substr(0, 1).toUpperCase() + day.substr(1, day.lenghth);
                    iconTextElement.appendChild(document.createTextNode(` ${day}`));
                    break;

            }

            forecastDayElement.appendChild(iconTextElement);

            let temperatureElement = document.createElement("td");

            let minimum = 0,
                maximum = 0,
                unit = "";

            if (i === -1){
                minimum = data.today.temperature.measure.minimum[MCCW.properties.weather.convention].value;
                maximum = data.today.temperature.measure.maximum[MCCW.properties.weather.convention].value;
                unit = data.today.temperature.measure.maximum[MCCW.properties.weather.convention].unit;
            } else {
                minimum = data.forecast.days[i].temperature.measure.minimum[MCCW.properties.weather.convention].value;
                maximum = data.forecast.days[i].temperature.measure.maximum[MCCW.properties.weather.convention].value;
                unit = data.forecast.days[i].temperature.measure.maximum[MCCW.properties.weather.convention].unit;
            };
            
            temperatureElement.appendChild(document.createTextNode(`${Math.round(minimum)} - ${Math.round(maximum)} ${unit}`));

            forecastDayElement.appendChild(temperatureElement);

            document.getElementById("weather").appendChild(forecastDayElement);
        }
    };
};

var weather_widget = {
    current: drawWeatherCurrentWidget,
    forecast: drawWeatherForecastWidget,
    location: drawWeatherLocationWidget,
    cache: {
        city: "",
        api_key: "",
        location: "",
        today: {...cacheWeatherToday},
        current: {...cacheWeatherCurrent},
        forecast: {...cacheWeatherForecast},
    },
    properties: {
        api_key: "",
        location: "",
        active: {
            all: false,
            current: true,
            forecast: true,
        },
        convention: "metric"
    }
}