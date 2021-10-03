package com.webShop.common.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IService
{
	String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException;
}
