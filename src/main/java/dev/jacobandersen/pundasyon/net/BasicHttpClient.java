package dev.jacobandersen.pundasyon.net;

import kong.unirest.HttpMethod;
import kong.unirest.HttpRequestWithBody;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.util.Map;
import java.util.function.BiFunction;

public abstract class BasicHttpClient {
    private final String url;
    private final Map<String, String> requiredParams;

    public BasicHttpClient(String url, Map<String, String> requiredParams) {
        this.url = url;
        this.requiredParams = requiredParams;
    }

    /**
     * Send a get request to the specified URL with extra params and extra headers, for the given response type
     *
     * @param responseType the class of the given response type
     * @param <T>          the given response type
     * @return a response wrapping the given response type
     */
    public <T> HttpResponse<T> get(Class<T> responseType, Map<String, String> params, Map<String, String> headers) {
        return get(null, responseType, params, headers);
    }

    /**
     * Send a get request to the specified URL with extra params and extra headers, for the given response type
     *
     * @param endpoint     the endpoint to hit if any
     * @param responseType the class of the given response type
     * @param <T>          the given response type
     * @return a response wrapping the given response type
     */
    public <T> HttpResponse<T> get(String endpoint, Class<T> responseType, Map<String, String> params, Map<String, String> headers) {
        return request(HttpMethod.GET, endpoint, responseType, params, headers);
    }

    /**
     * Send a post request to the specified URL with extra params and extra headers, for the given response type
     *
     * @param responseType the class of the given response type
     * @param <T>          the given response type
     * @return a response wrapping the given response type
     */
    public <T> HttpResponse<T> post(Class<T> responseType, Map<String, String> params, Map<String, String> headers) {
        return post(null, responseType, params, headers);
    }

    /**
     * Send a post request to the specified URL with extra params and extra headers, for the given response type
     *
     * @param responseType the class of the given response type
     * @param <T>          the given response type
     * @return a response wrapping the given response type
     */
    public <T> HttpResponse<T> post(String endpoint, Class<T> responseType, Map<String, String> params, Map<String, String> headers) {
        return request(HttpMethod.POST, endpoint, responseType, params, headers);
    }

    /**
     * Send a put request to the specified URL with extra params and extra headers, for the given response type
     *
     * @param responseType the class of the given response type
     * @param <T>          the given response type
     * @return a response wrapping the given response type
     */
    public <T> HttpResponse<T> put(Class<T> responseType, Map<String, String> params, Map<String, String> headers) {
        return put(null, responseType, params, headers);
    }

    /**
     * Send a put request to the specified URL with extra params and extra headers, for the given response type
     *
     * @param endpoint     the endpoint to hit if any
     * @param responseType the class of the given response type
     * @param <T>          the given response type
     * @return a response wrapping the given response type
     */
    public <T> HttpResponse<T> put(String endpoint, Class<T> responseType, Map<String, String> params, Map<String, String> headers) {
        return request(HttpMethod.PUT, endpoint, responseType, params, headers);
    }

    /**
     * Send a patch request to the specified URL with extra params and extra headers, for the given response type
     *
     * @param responseType the class of the given response type
     * @param <T>          the given response type
     * @return a response wrapping the given response type
     */
    public <T> HttpResponse<T> patch(Class<T> responseType, Map<String, String> params, Map<String, String> headers) {
        return patch(null, responseType, params, headers);
    }

    /**
     * Send a patch request to the specified URL with extra params and extra headers, for the given response type
     *
     * @param endpoint     the endpoint to hit if any
     * @param responseType the class of the given response type
     * @param <T>          the given response type
     * @return a response wrapping the given response type
     */
    public <T> HttpResponse<T> patch(String endpoint, Class<T> responseType, Map<String, String> params, Map<String, String> headers) {
        return request(HttpMethod.PATCH, endpoint, responseType, params, headers);
    }

    /**
     * Send a delete request to the specified URL with extra params and extra headers, for the given response type
     *
     * @param responseType the class of the given response type
     * @param <T>          the given response type
     * @return a response wrapping the given response type
     */
    public <T> HttpResponse<T> delete(Class<T> responseType, Map<String, String> params, Map<String, String> headers) {
        return delete(null, responseType, params, headers);
    }

    /**
     * Send a delete request to the specified URL with extra params and extra headers, for the given response type
     *
     * @param endpoint     the endpoint to hit if any
     * @param responseType the class of the given response type
     * @param <T>          the given response type
     * @return a response wrapping the given response type
     */
    public <T> HttpResponse<T> delete(String endpoint, Class<T> responseType, Map<String, String> params, Map<String, String> headers) {
        return request(HttpMethod.DELETE, endpoint, responseType, params, headers);
    }

    /**
     * Send a completely custom request of arbitrary method with given response type, extra params and extra headers
     *
     * @param method       the HTTP method to use
     * @param endpoint     the endpoint to hit if any
     * @param responseType the class of the given response type
     * @param <T>          the given response type
     * @return a response wrapping the given response type
     */
    public <T> HttpResponse<T> request(HttpMethod method, String endpoint, Class<T> responseType, Map<String, String> params, Map<String, String> headers) {
        String url;
        if (endpoint == null) {
            url = this.url;
        } else {
            url = String.format("%s/%s", this.url, endpoint);
        }

        HttpRequestWithBody req = Unirest.request(method.name(), url);

        if (requiredParams != null && !requiredParams.isEmpty()) {
            req = applyQueryStrings(req, requiredParams);
        }

        if (params != null && !params.isEmpty()) {
            req = applyQueryStrings(req, params);
        }

        if (headers != null && !headers.isEmpty()) {
            req = applyHeaders(req, headers);
        }

        return req.asObject(responseType);
    }

    private HttpRequestWithBody applyQueryStrings(HttpRequestWithBody request, Map<String, String> queryStrings) {
        return mutateFromMap(request, queryStrings, (req, qs) -> req.queryString(qs.getKey(), qs.getValue()));
    }

    private HttpRequestWithBody applyHeaders(HttpRequestWithBody request, Map<String, String> headers) {
        return mutateFromMap(request, headers, (req, entry) -> req.header(entry.getKey(), entry.getValue()));
    }

    private HttpRequestWithBody mutateFromMap(HttpRequestWithBody request, Map<String, String> entries, BiFunction<HttpRequestWithBody, Map.Entry<String, String>, HttpRequestWithBody> function) {
        for (Map.Entry<String, String> entry : entries.entrySet()) {
            request = function.apply(request, entry);
        }

        return request;
    }
}
