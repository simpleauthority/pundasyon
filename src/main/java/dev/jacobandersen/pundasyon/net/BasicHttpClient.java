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
     * Send a get request to the specified URL, no extra params and no extra headers, for the given response type
     *
     * @param responseType the class of the given response type
     * @param <T>          the given response type
     * @return a response wrapping the given response type
     */
    public <T> HttpResponse<T> get(Class<T> responseType) {
        return get(responseType, null, null);
    }

    /**
     * Send a get request to the specified URL with extra params and extra headers, for the given response type
     *
     * @param responseType the class of the given response type
     * @param <T>          the given response type
     * @return a response wrapping the given response type
     */
    public <T> HttpResponse<T> get(Class<T> responseType, Map<String, String> params, Map<String, String> headers) {
        return request(HttpMethod.GET, responseType, params, headers);
    }

    /**
     * Send a post request to the specified URL, no extra params and no extra headers, for the given response type
     *
     * @param responseType the class of the given response type
     * @param <T>          the given response type
     * @return a response wrapping the given response type
     */
    public <T> HttpResponse<T> post(Class<T> responseType) {
        return get(responseType, null, null);
    }

    /**
     * Send a post request to the specified URL with extra params and extra headers, for the given response type
     *
     * @param responseType the class of the given response type
     * @param <T>          the given response type
     * @return a response wrapping the given response type
     */
    public <T> HttpResponse<T> post(Class<T> responseType, Map<String, String> params, Map<String, String> headers) {
        return request(HttpMethod.POST, responseType, params, headers);
    }

    /**
     * Send a put request to the specified URL, no extra params and no extra headers, for the given response type
     *
     * @param responseType the class of the given response type
     * @param <T>          the given response type
     * @return a response wrapping the given response type
     */
    public <T> HttpResponse<T> put(Class<T> responseType) {
        return get(responseType, null, null);
    }

    /**
     * Send a put request to the specified URL with extra params and extra headers, for the given response type
     *
     * @param responseType the class of the given response type
     * @param <T>          the given response type
     * @return a response wrapping the given response type
     */
    public <T> HttpResponse<T> put(Class<T> responseType, Map<String, String> params, Map<String, String> headers) {
        return request(HttpMethod.PUT, responseType, params, headers);
    }

    /**
     * Send a patch request to the specified URL, no extra params and no extra headers, for the given response type
     *
     * @param responseType the class of the given response type
     * @param <T>          the given response type
     * @return a response wrapping the given response type
     */
    public <T> HttpResponse<T> patch(Class<T> responseType) {
        return get(responseType, null, null);
    }

    /**
     * Send a patch request to the specified URL with extra params and extra headers, for the given response type
     *
     * @param responseType the class of the given response type
     * @param <T>          the given response type
     * @return a response wrapping the given response type
     */
    public <T> HttpResponse<T> patch(Class<T> responseType, Map<String, String> params, Map<String, String> headers) {
        return request(HttpMethod.PATCH, responseType, params, headers);
    }

    /**
     * Send a delete request to the specified URL, no extra params and no extra headers, for the given response type
     *
     * @param responseType the class of the given response type
     * @param <T>          the given response type
     * @return a response wrapping the given response type
     */
    public <T> HttpResponse<T> delete(Class<T> responseType) {
        return get(responseType, null, null);
    }

    /**
     * Send a delete request to the specified URL with extra params and extra headers, for the given response type
     *
     * @param responseType the class of the given response type
     * @param <T>          the given response type
     * @return a response wrapping the given response type
     */
    public <T> HttpResponse<T> delete(Class<T> responseType, Map<String, String> params, Map<String, String> headers) {
        return request(HttpMethod.DELETE, responseType, params, headers);
    }

    /**
     * Send a completely custom request of arbitrary method with given response type, extra params and extra headers
     *
     * @param responseType the class of the given response type
     * @param <T>          the given response type
     * @return a response wrapping the given response type
     */
    public <T> HttpResponse<T> request(HttpMethod method, Class<T> responseType, Map<String, String> params, Map<String, String> headers) {
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
